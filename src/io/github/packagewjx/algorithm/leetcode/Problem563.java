package io.github.packagewjx.algorithm.leetcode;


/**
 * Created by 吴俊贤 on 2017/4/25.
 */
public class Problem563 {
	public static void main(String[] args) {
		TreeNode treeNode = TreeTraverse.constructTreeInLeetCode(new Integer[]{1, 2, 3});
		Solution solution = new Problem563().new Solution();

	}

	public class Solution {
		private int tilt;
		public int findTilt(TreeNode root) {
			tilt = 0;
			traverse(root);
			return tilt;
		}

		private int traverse(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int left = traverse(root.left);
			int right = traverse(root.right);
			tilt += Math.abs(left - right);
			return root.val + left + right;
		}
	}
}
