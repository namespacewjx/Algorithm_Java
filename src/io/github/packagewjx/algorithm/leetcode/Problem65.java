package io.github.packagewjx.algorithm.leetcode;

/**
 * 狗！不写了，描述不清楚，一直靠猜
 */
public class Problem65 {
    public static void main(String[] args) {

    }

    public class Solution {
        public boolean isNumber(String s) {
            s = s.trim();
            return s.matches("\\-?(\\d*\\.?\\d*e-?)?\\d+\\.?\\d+");
        }
    }
}