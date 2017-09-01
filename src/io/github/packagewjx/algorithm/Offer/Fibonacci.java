package io.github.packagewjx.algorithm.Offer;

/**
 * @author 吴俊贤
 * Email: wu812730157@gmail.com
 * Date: 17-9-1
 **/
public class Fibonacci {
    public static void main(String[] args) {
        new Fibonacci().new Solution().Fibonacci(10);
    }

    public class Solution {
        public int Fibonacci(int n) {
            if (n == 0)
                return 0;
            int[] nums = new int[n + 1];
            nums[1] = 1;
            for (int i = 2; i < nums.length; i++) {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
            return nums[n];
        }
    }
}
