package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/7/16.
 * Reshape the Matrix
 * https://leetcode.com/problems/reshape-the-matrix/#/description
 */
public class Problem566 {
	public static void main(String[] args) {
		Problem566 problem566 = new Problem566();
		Solution solution = problem566.new Solution();

		int[][] nums = new int[4][3];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				nums[i][j] = i + j;
			}
		}


	}

	public class Solution {
		public int[][] matrixReshape(int[][] nums, int r, int c) {
			if (nums.length * nums[0].length != r * c) {
				return nums;
			}

			this.nums = nums;
			int[][] result = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					result[i][j] = fetchNext();
				}
			}
			return result;
		}

		int curRow;
		int curCol;
		int[][] nums;

		public int fetchNext() {
			if (curCol == nums[0].length) {
				curCol = 0;
				curRow++;
			}
			return nums[curRow][curCol++];
		}
	}

	//取余法，复制过来的，快很多，不再需要判断了
	public class Solution1 {
		public int[][] matrixReshape(int[][] nums, int r, int c) {
			int[][] res = new int[r][c];
			if (nums.length == 0 || r * c != nums.length * nums[0].length)
				return nums;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums[0].length; j++) {
					res[count / c][count % c] = nums[i][j];
					count++;
				}
			}
			return res;
		}
	}
}
