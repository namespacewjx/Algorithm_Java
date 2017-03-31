package io.wicp.namespacewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/3/30.
 */
public class Problem485 {
	public static void main(String[] args) {
		System.out.println(new Problem485().new Solution().findMaxConsecutiveOnes(new int[]{0}));
	}


	public class Solution {
		public int findMaxConsecutiveOnes(int[] nums) {
			int biggest = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					continue;
				}
				int count = 1;
				int j = i + 1;
				for (; j < nums.length && nums[j] == 1; j++) {
					count++;
				}
				i = j;
				if (biggest < count)
					biggest = count;
			}
			return biggest;
		}
	}
}
