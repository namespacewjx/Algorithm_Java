package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/6.
 */
public class Problem303 {

	public static void main(String[] args) {
		NumArray numArray = new Problem303().new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
		numArray.sumRange(0, 2);
		numArray.sumRange(2, 5);
		numArray.sumRange(0, 5);
	}

	public class NumArray {
		public int NULL = Integer.MIN_VALUE;

		int[][] result;
		int[] nums;

		public NumArray(int[] nums) {
			if (nums == null || nums.length == 0) {
				return;
			}

			result = new int[nums.length][];
			result[0] = nums;
			for (int i = 1; i < result.length; i++) {
				result[i] = new int[nums.length - i];
				for (int j = 0; j < result[i].length; j++) {
					result[i][j] = NULL;
				}
			}

			this.nums = nums;
		}

		public int sumRange(int i, int j) {
			if (i < 0 || i > nums.length || j < 0 || j > nums.length || j < i) {
				return NULL;
			}

			if (i == j)
				return result[0][i];

			int resultij;
			if (result[j - i - 1][i] != NULL) {
				 resultij = result[j - i - 1][i] + nums[j];
			} else {
				resultij = sumRange(i + 1, j) + nums[i];
			}
			result[j - i][i] = resultij;//保存记忆结果
			return resultij;
		}
	}
}
