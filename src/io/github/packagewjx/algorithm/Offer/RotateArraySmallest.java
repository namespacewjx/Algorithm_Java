package io.github.packagewjx.algorithm.Offer;

/**
 * @author 吴俊贤
 * Email: wu812730157@gmail.com
 * Date: 17-9-1
 **/
public class RotateArraySmallest {
    public static void main(String[] args) {
        System.out.println(new RotateArraySmallest().new Solution().minNumberInRotateArray(new int[]{1,1,1,1,1,1,1,1,1,1,1}));
    }

    public class Solution {
        public int minNumberInRotateArray(int[] array) {
            if (array[0] == array[array.length - 1] && array[0] == array[(array.length - 1) / 2]) {
                int smallest = Integer.MAX_VALUE;
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < smallest)
                        smallest = array[i];
                }
                return smallest;
            } else if (array[0] < array[array.length - 1]) {
                return array[0];
            }

            int l = 0;
            int r = array.length - 1;
            int m = (l + r) / 2;
            while (l + 1 != r) {
                if (array[l] <= array[m])
                    l = m;
                else
                    r = m;
                m = (l + r) / 2;
            }
            return array[r];
        }
    }
}
