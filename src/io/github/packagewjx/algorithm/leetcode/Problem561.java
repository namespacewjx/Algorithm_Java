package io.github.packagewjx.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by 吴俊贤 on 2017/4/25.
 */
public class Problem561 {
	public static void main(String[] args) {

	}


	public class Solution {
		public int arrayPairSum(int[] nums) {
			Arrays.sort(nums);
			int sum = 0;
			for (int i = 0; i < nums.length; i += 2) {
				sum += nums[i];
			}
			return sum;
		}
	}
}
