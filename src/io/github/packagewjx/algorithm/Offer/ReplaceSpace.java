package io.github.packagewjx.algorithm.Offer;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author 吴俊贤
 * Email: wu812730157@gmail.com
 * Date: 17-9-1
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 **/
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().new Solution2().replaceSpace(new StringBuffer(null)));
    }

    //这种解法是作弊的吧
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ')
                    str.replace(i, i + 1, "%20");
            }
            return str.toString();
        }
    }

    public class Solution2 {
        public String replaceSpace(StringBuffer str) {
            char[] string = str.toString().toCharArray();
            //这才是开始正式解题
            int spaceCount = 0;
            for (int i = 0; i < string.length; i++) {
                if (string[i] == ' ')
                    spaceCount++;
            }
            char[] result = new char[string.length + spaceCount * 2];
            int index = result.length - 1;
            for (int i = string.length - 1; i >= 0; i--) {
                if (string[i] == ' ') {
                    result[index--] = '0';
                    result[index--] = '2';
                    result[index--] = '%';
                } else {
                    result[index--] = string[i];
                }
            }
            return new String(result);
        }
    }


}
