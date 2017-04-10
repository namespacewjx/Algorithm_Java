package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/6.
 */
public class Problem53 {


	//比较“教材”的动态规划算法，很慢，只打败了12%的。
	public class Solution {
		public int maxSubArray(int[] nums) {
			if (nums == null || nums.length == 0) {
				return 0;
			}

			int[] sum = new int[nums.length];
			int biggest = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (sum[i - 1] <= 0)
					sum[i] = nums[i];
				else
					sum[i] = nums[i] + sum[i - 1];

				if (sum[i] > biggest)
					biggest = sum[i];
			}

			return biggest;
		}
	}
}
