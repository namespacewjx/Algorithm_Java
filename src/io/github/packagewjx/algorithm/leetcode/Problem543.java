package io.github.packagewjx.algorithm.leetcode;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-8-29
 * 描述：
 **/
public class Problem543 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeTraverse.constructTreeInLeetCode(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(new Problem543().new Solution().diameterOfBinaryTree(treeNode));
    }

    class Solution {
        private int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            visit(root);
            return diameter;
        }

        public int visit(TreeNode root) {
            if (root == null)
                return 0;

            int left = visit(root.left);
            int right = visit(root.right);
            if (left + right > diameter)
                diameter = left + right;
            return left > right ? left + 1 : right + 1;
        }
    }
}
