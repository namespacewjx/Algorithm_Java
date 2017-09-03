package io.github.packagewjx.algorithm.leetcode;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-8-29
 * 描述：Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 **/
public class Problem108 {
    public static void main(String[] args) {
        TreeNode node = new Problem108().new Solution().sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0)
                return null;
            return constrct(nums, 0, nums.length - 1);
        }

        private TreeNode constrct(int[] nums, int left, int right) {
            if (left > right)
                return null;
            if (left == right) {
                return new TreeNode(nums[left]);
            }
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = constrct(nums, left, mid - 1);
            node.right = constrct(nums, mid + 1, right);
            return node;
        }
    }
}
