package io.github.packagewjx.algorithm.Offer;

import io.github.packagewjx.algorithm.leetcode.TreeNode;
import io.github.packagewjx.algorithm.leetcode.TreeTraverse;

import java.util.ArrayList;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-3
 * 描述：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 **/
public class FindPath {
    public static void main(String[] args) {
        TreeNode tree = TreeTraverse.constructTreeInLeetCode(new Integer[]{5, 4, null, 3, null, 2, null, 1});
        new FindPath().new Solution().FindPath(tree, 10);
    }

    public class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root == null)
                return result;
            traverse(root, new ArrayList<Integer>(), target, 0);
            return result;
        }

        public void traverse(TreeNode root, ArrayList<Integer> path, int target, int current) {
            if (root.left == null && root.right == null) {
                current += root.val;
                if (current == target) {
                    path.add(root.val);
                    result.add(path);
                }
            } else {
                path.add(root.val);
                current += root.val;
                ArrayList<Integer> anotherPath = new ArrayList<>(path);
                if (root.left != null)
                    traverse(root.left, path, target, current);
                if (root.right != null)
                    traverse(root.right, anotherPath, target, current);
            }
        }

    }
}
