package io.github.packagewjx.algorithm.leetcode;

/**
 * UTF-8 Validation
 * https://leetcode.com/problems/utf-8-validation/description/
 */
public class Problem393 {
    public static void main(String[] args) {
        int[] data = {145};
        new Problem393().new Solution().validUtf8(data);
    }

    public class Solution {
        public boolean validUtf8(int[] data) {
            for (int i = 0; i < data.length; i++) {
                int b = data[i];
                //首先判断第一个字节的前4位是否符合要求
                if (b < 128)
                    continue;
                int n = 0;
                //计算前面有多少个连续的1，只有1,2,3个才行
                int mask = 0b1000000;
                while (n < 4) {
                    if ((b & mask) == mask) {
                        n++;
                        mask >>>= 1;
                    } else
                        break;
                }
                if (n > 3 || n == 0)
                    return false;


                while (n > 0) {
                    try {
                        b = data[++i];
                        if ((b >>> 6) != 0b10)
                            return false;
                        n--;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        //借助异常，判断是否出界，出界了n不为0，则是错误
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
