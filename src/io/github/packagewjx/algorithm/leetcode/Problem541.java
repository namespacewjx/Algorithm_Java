package io.github.packagewjx.algorithm.leetcode;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-8-29
 * 描述：https://leetcode.com/problems/reverse-string-ii/description/
 **/
public class Problem541 {
    public static void main(String[] args) {
        System.out.println(new Problem541().new Solution().reverseStr("abcdefg", 4));
    }

    class Solution {
        public String reverseStr(String s, int k) {
            if (s == null)
                return "";
            StringBuilder builder = new StringBuilder(s.length() + 1);
            boolean reverse = true;
            for (int i = 0; i < s.length(); i += k) {
                if (reverse) {
                    int j = i + k - 1 < s.length() ? i + k - 1 : s.length() - 1;
                    while (j >= i) {
                        builder.append(s.charAt(j--));
                    }
                } else {
                    int j = i;
                    while (j < s.length() && j < i + k) {
                        builder.append(s.charAt(j++));
                    }
                }
                reverse = !reverse;
            }
            return builder.toString();
        }
    }
}

