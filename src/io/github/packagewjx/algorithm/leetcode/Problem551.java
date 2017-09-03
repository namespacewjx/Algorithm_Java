package io.github.packagewjx.algorithm.leetcode;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-8-29
 * 描述：Student Attendance Record I
 * https://leetcode.com/problems/student-attendance-record-i/description/
 **/
public class Problem551 {

    class Solution {
        public boolean checkRecord(String s) {
            int ACount = 0;
            int i = 0;
            while (i < s.length()) {
                char record = s.charAt(i);
                if (record == 'A')
                    ACount++;
                else if (record == 'L') {
                    if (i + 2 < s.length() && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
                        return false;
                }
                i++;
            }
            return ACount <= 1;
        }
    }

    class Solution2 {
        public boolean checkRecord(String s) {
            return !s.matches(".*LLL.*|.*A.*A.*");
        }
    }
}



