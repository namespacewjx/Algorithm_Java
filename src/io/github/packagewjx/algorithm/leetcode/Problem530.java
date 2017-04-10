package io.github.packagewjx.algorithm.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * Created by 吴俊贤 on 2017/4/5.
 */
public class Problem530 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//递归求最大值，慢，28ms
	public class Solution {
		public int getMinimumDifference(TreeNode root) {
			if (root == null)
				return Integer.MAX_VALUE;

			int left = getMinimumDifference(root.left);
			int right = getMinimumDifference(root.right);

			left = left < right ? left : right;

			int leftDiff = Integer.MAX_VALUE, rightDiff = Integer.MAX_VALUE;

			if (root.left != null)
				leftDiff = root.val - findMax(root.left);
			if (root.right != null)
				rightDiff = findMin(root.right) - root.val;

			leftDiff = leftDiff < rightDiff ? leftDiff : rightDiff;

			return left < leftDiff ? left : leftDiff;
		}

		private int findMax(TreeNode root) {
			if (root == null)
				return Integer.MIN_VALUE;
			while (root.right != null)
				root = root.right;
			return root.val;
		}

		private int findMin(TreeNode root) {
			if (root == null)
				return Integer.MAX_VALUE;
			while (root.left != null)
				root = root.left;
			return root.val;
		}

	}

	//直接中序遍历出结果
//	18ms，秒杀95%的算法啊！
	public class Solution2 {
		private int lastValue;

		public int getMinimumDifference(TreeNode root) {
			if (root == null)
				return Integer.MAX_VALUE;
			initLastValue(root);
			return traverse(root);
		}

		private void initLastValue(TreeNode root) {
			TreeNode cur = root;
			while (cur.left != null) {
				cur = cur.left;
			}
			lastValue = cur.val - Integer.MAX_VALUE;
		}

		private int traverse(TreeNode root) {
			if (root == null)
				return Integer.MAX_VALUE;

			//先得到左节点的最小值
			int smallest = traverse(root.left);

			//得到本节点和上节点的差值，然后与左节点的比较
			if (root.val - lastValue < smallest)
				smallest = root.val - lastValue;
			lastValue = root.val;//设置这个，保证正确

			//比较右节点的
			int right = traverse(root.right);
			if (smallest > right)
				smallest = right;

			return smallest;
		}
	}

}
