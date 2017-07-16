package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/7/16.
 * Convert BST to Greater Tree
 * https://leetcode.com/problems/convert-bst-to-greater-tree/#/description
 */
public class Problem538 {
	public class Solution {
		int currentSum;
		public TreeNode convertBST(TreeNode root) {
			if (root == null)
				return null;

			convertBST(root.right);

			int oriVal = root.val;
			root.val += currentSum;
			currentSum += oriVal;

			convertBST(root.left);

			return root;
		}
	}
}
