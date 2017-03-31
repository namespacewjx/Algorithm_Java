package io.wicp.namespacewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/3/25.
 * <a href="https://leetcode.com/problems/reverse-string/#/description">题目网址</a>
 */
public class Problem344 {
	public static void main(String[] args) {
		System.out.println(new Problem344().new Solution().reverseString("hello"));
	}

	public class Solution {
		public String reverseString(String s) {
			return way2(s);
		}

		//只比20%的人快的方法
		public String way1(String s) {
			StringBuilder builder = new StringBuilder(s.length());
			for (int i = s.length() - 1; i >= 0; i--) {
				builder.append(s.charAt(i));
			}
			return builder.toString();
		}

		//比较快的方法，采用交换位置的方式
		public String way2(String s) {
			char[] word = s.toCharArray();
			int i = 0;
			int j = s.length() - 1;
			while (i < j) {
				char temp = word[i];
				word[i] = word[j];
				word[j] = temp;
				i++;
				j--;
			}
			return new String(word);
		}
	}
}
