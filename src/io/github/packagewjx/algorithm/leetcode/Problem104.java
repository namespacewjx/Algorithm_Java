package io.github.packagewjx.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by 吴俊贤 on 2017/3/31.
 */
public class Problem104 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);

		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t3.left = t4;
		t3.right = t5;
		t5.left = t6;
		t2.left = t7;
		t2.right = t8;
		t7.left = t9;
		System.out.println(new Problem104().new Solution2().maxDepth(root));

	}
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//递归，最快的方案。1ms
	public class Solution {
		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			int left = 0;
			int right = 0;
			if (root.left != null) {
				left = maxDepth(root.left);
			}
			if (root.right != null) {
				right = maxDepth(root.right);
			}
			return left > right ? left + 1 : right + 1;
		}
	}

	//不利用递归的深度优先算法，利用Stack结构。4ms
	public class Solution1 {
		public int maxDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}

			Stack<TreeNode> stack = new Stack<>();
			root.val = 1;
			int maxDepth = 1;

			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode cur = stack.pop();
				if (maxDepth < cur.val)
					maxDepth = cur.val;
				if (cur.right != null){
					stack.push(cur.right);
					cur.right.val = cur.val + 1;
				}
				if (cur.left != null){
					stack.push(cur.left);
					cur.left.val = cur.val + 1;
				}
			}
			return maxDepth;
		}
	}

	//广度优先算法，利用队列。这个快了点，2ms
	public class Solution2 {
		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;

			LinkedList<TreeNode> queue = new LinkedList<>();
			root.val = 1;
			queue.add(root);

			TreeNode cur;
			int maxDepth = 1;
			while ((cur = queue.poll()) != null) {
				if (cur.val > maxDepth) {
					maxDepth = cur.val;
				}
				if (cur.left != null) {
					cur.left.val = cur.val + 1;
					queue.add(cur.left);
				}
				if (cur.right != null) {
					cur.right.val = cur.val + 1;
					queue.add(cur.right);
				}
			}

			return maxDepth;
		}
	}
}
