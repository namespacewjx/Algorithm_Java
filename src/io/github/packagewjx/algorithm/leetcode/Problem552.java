package io.github.packagewjx.algorithm.leetcode;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-8-27
 * 描述：
 **/
public class Problem552 {
    class Solution {
        private int[][] num;

        public int checkRecord(int n) {
            if (n == 0) return 0;
            if (n == 1) return 3;
            if (n == 2) return 8;

            func(n, (n + 1) / 2);

            int result = 0;
            //A有0个
            result = 1;//L有0个，则只有一种情况
            for (int i = 1; i < (n + 1) / 2; i++) {
                result += doCal(n - i * 2 + 1, i + 1);
            }

            //A有1个
            return 0;

        }

        public void func(int n, int k) {
            num = new int[n + 1][k + 1];
            for (int i = 0; i < n + 1; i++) {
                num[i][0] = 1;
                num[i][1] = 1;
            }
            for (int i = 1; i < k + 1; i++) {
                num[0][i] = 1;
                num[1][i] = i;
            }

            doCal(n, k);
        }

        public int doCal(int n, int k) {
            if (num[n][k] != 0) {
                return num[n][k];
            }
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += doCal(i, k - 1);
            }
            num[n][k] = sum;
            return sum;
        }
    }


}
