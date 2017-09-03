package io.github.packagewjx.algorithm.Offer;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-3
 * 描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 **/
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        new VerifySquenceOfBST().new Solution().VerifySquenceOfBST(new int[]{1, 3, 2, 5, 7, 6, 4});
    }

    public class Solution {
        public boolean VerifySquenceOfBST(int [] sequence) {
            if (sequence == null || sequence.length == 0)
                return false;
            return verify(sequence, 0, sequence.length - 1);
        }

        private boolean verify(int[] sequence, int left, int right) {
            if (left >= right)
                return true;
            int i = left;
            int root = sequence[right];
            while (sequence[i] < root)
                i++;
            int leftEnd = i - 1;
            while (sequence[i] > root)
                i++;
            if (i != right)
                return false;
            return verify(sequence, left, leftEnd) && verify(sequence, leftEnd + 1, right - 1);
        }
    }
}
