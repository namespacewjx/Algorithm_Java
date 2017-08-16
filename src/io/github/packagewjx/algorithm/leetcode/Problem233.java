package io.github.packagewjx.algorithm.leetcode;

/**
 * Number of Digit One
 * https://leetcode.com/problems/number-of-digit-one/description/
 */
public class Problem233 {
    public static void main(String[] args) {
        new Problem233().new Solution().countDigitOne(15247);
    }

    public class Solution {
        public int countDigitOne(int n) {
            if (n == 0)
                return 0;

            int result = 0;
            int high1 = 0;
            int weishu = ((int) (Math.log(n) / Math.log(10)));
            for (int i = weishu; i > 0; i--) {
                int zheng = (int) Math.pow(10, i);
                int highDigit = n / zheng;
                n = n - highDigit * zheng;
                for (int j = 0; j < highDigit; j++) {
                    result += getOccurenceInAll(i) + (j == 1 ? getOccurenceInAll(i) : 0) + high1 * getOccurenceInAll(i);
                }
                if (highDigit == 1)
                    high1++;
            }
            return result;
        }

        public int[] occurence = new int[10];//存着下面函数的结果

        /**
         * 获取n位数字任取的时候，有多少个1的结果
         *
         * @param n
         * @return
         */
        public int getOccurenceInAll(int n) {
            if (n == 0)
                return 0;
            if (occurence[n] == 0) {
                occurence[n] = doCal(n);
            }
            return occurence[n];
        }

        /**
         * 实际计算的函数
         *
         * @param n
         * @return
         */
        public int doCal(int n) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                result += C(i + 1, n) * powerOf8(n - i - 1) * (i + 1);
            }
            return result;
        }

        public int C(int n, int m) {
            if (n > m / 2)
                n = m - n;
            int result = 1;
            for (int i = 0; i < n; i++) {
                result *= (m - i);
            }
            for (int i = 0; i < n; i++) {
                result /= (i + 1);
            }
            return result;
        }

        public int powerOf8(int pow) {
            return 1 << (pow * 3);
        }


    }
}
