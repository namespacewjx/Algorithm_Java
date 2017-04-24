package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/24.
 */
public class Problem404 {


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public int sumOfLeftLeaves(TreeNode root) {
			if (root == null)
				return 0;

			return traverse(root, false);
		}

		public int traverse(TreeNode cur, boolean isLeft) {
			if (cur.left == null && cur.right == null && isLeft) {
				return cur.val;
			}

			return (cur.left != null ? traverse(cur.left, true) : 0) + (cur.right != null ? traverse(cur.right, false) : 0);
		}
	}
}
