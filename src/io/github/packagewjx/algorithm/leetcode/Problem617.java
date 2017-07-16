package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/7/15.
 * https://leetcode.com/submissions/detail/109734114/
 */
public class Problem617 {

	public static void main(String[] args) {
		Problem617 problem617 = new Problem617();
		Solution solution = problem617.new Solution();
		TreeNode t1 = TreeTraverse.constructTreeInLeetCode(new Integer[]{1, 3, 2, 5});
		TreeNode t2 = TreeTraverse.constructTreeInLeetCode(new Integer[]{2, 1, 3, null, 4, null, 7});
		TreeNode t3 = solution.mergeTrees(t1, t2);
		t3.toString();
	}


	public class Solution {
		public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
			if (t1 == null && t2 == null)
				return null;

			if (t1 == null)
				return t2;
			if (t2 == null)
				return t1;

			t1.val += t2.val;
			t1.left = mergeTrees(t1.left, t2.left);
			t1.right = mergeTrees(t1.right, t2.right);
			return t1;
		}
	}

}