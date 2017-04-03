package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/1.
 */
public class Problem226 {

	public static void main(String[] args) {

	}


	//	  Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public TreeNode invertTree(TreeNode root) {
			if (root == null)
				return null;
			invertTree(root.left);
			invertTree(root.right);
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			return root;
		}
	}
}
