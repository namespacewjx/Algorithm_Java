package io.github.packagewjx.algorithm.Offer;

import io.github.packagewjx.algorithm.leetcode.TreeNode;

/**
 * @author 吴俊贤
 * Email: wu812730157@gmail.com
 * Date: 17-9-1
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 **/
public class ReconstructBinaryTree {
    public static void main(String[] args) {
        new ReconstructBinaryTree().new Solution().reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }

    public class Solution {
        public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
            if (pre == null || in == null)
                return null;
            return contruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        private TreeNode contruct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
            if (preStart > preEnd)
                return null;
            if (preStart == preEnd)
                return new TreeNode(pre[preStart]);

            TreeNode root = new TreeNode(pre[preStart]);
            int rootIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (in[i] == pre[preStart]) {
                    rootIndex = i;
                    break;
                }
            }
            int leftNum = rootIndex - inStart;

            root.left = contruct(pre, preStart + 1, preStart + leftNum, in, inStart, rootIndex - 1);
            root.right = contruct(pre, preStart + leftNum + 1, preEnd, in, rootIndex + 1, inEnd);
            return root;
        }
    }
}
