public class Finder {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 2, 2, 5, 3};

        Finder finder = new Finder();
        int result = finder.findKth(nums, nums.length, 3);
    }

    public int findKth(int[] a, int n, int K) {
        int result = partition(a, 0, a.length - 1);
        int start = 0;
        int end = a.length - 1;
        while (result != K) {
            if (result < K) {
                start = result;
            } else {
                end = result;
            }
            result = partition(a, start, end);
        }
        return a[result];
    }

    public int partition(int[] nums, int start, int end) {
        if (start == end)
            return start;
        int l = start + 1;
        int r = end;
        int mid = (l + r) / 2;
        swap(nums, mid, 0);

        int pivot = nums[0];

        while (l <= r) {
            while (nums[l] <= pivot && l <= r)
                l++;
            while (nums[r] > pivot && l <= r)
                r--;
            swap(nums, l, r);
        }

        swap(nums, 0, r);
        return r;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}