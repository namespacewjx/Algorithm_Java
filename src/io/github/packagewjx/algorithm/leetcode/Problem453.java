package io.github.packagewjx.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by 吴俊贤 on 2017/4/13.
 *
 *
 */
public class Problem453 {

	/**
	 * 解题思路，先找出最小的元素，然后每次把第一个元素加到第二个元素那么大，之后继续加，让1、2个元素加到第3个元素那么大，
	 * 以此类推，依次让他们相等，最后就出结果了
	 * 可以一次算出来，为第二个元素到第n个元素减去第一个元素的差的和
	 */
	public class Solution {
		public int minMoves(int[] nums) {
			int smallest = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] < smallest)
					smallest = nums[i];
			}
			int result = 0;
			for (int i = 0; i < nums.length; i++) {
				result += nums[i] - smallest;
			}
			return result;
		}
	}

	/**
	 * 相信可以优化，只遍历一次，先找出局部最小，算出步数值，如果新的数比局部最小要小，那么修改结果，只需再加上新小与旧小的差值乘以前面的数目
	 * 很强，打败了78%
	 */
	public class Solution2 {
		public int minMoves(int[] nums) {
			int smallest = nums[0];
			int result = 0;

			for (int i = 1; i < nums.length; i++) {
				if (smallest > nums[i]) {
					//调整结果至新的结果
					result += (smallest - nums[i]) * i;
					smallest = nums[i];
					continue;
				}
				result += nums[i] - smallest;
			}

			return result;
		}
	}
}
