package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/7/16.
 * Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/#/description
 */
public class Problem606 {

	public class Solution {
		public String tree2str(TreeNode t) {
			if (t == null)
				return "";

			traverse(t);
			return builder.toString();
		}

		StringBuilder builder = new StringBuilder();

		public void traverse(TreeNode treeNode) {
			builder.append(treeNode.val);

			//叶子节点的话，不能继续打印，直接返回
			if (treeNode.left == null && treeNode.right == null)
				return;

			//左边节点为空的话，也有一对括号
			builder.append('(');
			if (treeNode.left != null)
				traverse(treeNode.left);
			builder.append(')');

			//右边节点为空的话，不能打印括号
			if (treeNode.right != null) {
				builder.append('(');
				traverse(treeNode.right);
				builder.append(')');
			}
		}
	}
}

