package io.github.packagewjx.algorithm.leetcode;

import java.util.Stack;

/**
 * Created by 吴俊贤 on 2017/4/14.
 */
public class Problem557 {
	public static void main(String[] args) {
		Solution3 solution = new Problem557().new Solution3();
		System.out.println(solution.reverseWords("Let's take LeetCode contest"));
	}

	/**
	 * 25ms
	 */
	public class Solution {
		public String reverseWords(String s) {
			if (s == null || s.length() == 0)
				return "";

			String[] words = s.split(" ");
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < words.length - 1; i++) {
				builder.append(reverseAWord(words[i]) + " ");
			}
			builder.append(reverseAWord(words[words.length - 1]));

			return builder.toString();
		}

		private String reverseAWord(String s) {
			StringBuilder builder = new StringBuilder(s.length());
			char[] str = s.toCharArray();//转换成char数组，遍历的时候方便
			//从后往前遍历，将后面的字符append到结果中去就行了
			for (int i = str.length - 1; i >= 0; i--) {
				builder.append(str[i]);
			}
			return builder.toString();
		}
	}

	/**
	 * 使用栈，一次遍历
	 * 但是用了76ms！
	 */
	public class Solution2 {
		public String reverseWords(String s) {
			Stack<Character> stack = new Stack<>();
			StringBuilder builder = new StringBuilder(s.length());
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c != ' ') {
					stack.push(c);
				} else {
					while (!stack.isEmpty())
						builder.append(stack.pop());
					builder.append(' ');
				}
			}
			while (!stack.isEmpty())
				builder.append(stack.pop());
			return builder.toString();
		}
	}

	/**
	 * 使用chararray来做，最快，10ms搞定，看来还是用底层的东西最快
	 */
	public class Solution3 {
		public String reverseWords(String s) {
			char[] str = s.toCharArray();//转换成char数组，方便调换字符位置
			int start = 0;
			for (int i = 1; i < str.length; i++) {
				if (str[i] == ' ') {
					//当遇到一个空格，就翻转前面从start到当前空格位置的单词，不包含当前空格
					reverseAWord(str, start, i);
					start = i + 1;
				}
			}
			reverseAWord(str, start, str.length);
			return new String(str);
		}

		/**
		 * 调换start到end（不包括）之间的字符的顺序
		 * @param str 包含需要调换顺序的单词的字符数组
		 * @param start 开始的第一个，包含在内
		 * @param end 超尾元素，不算在内
		 */
		public void reverseAWord(char[] str, int start, int end) {
			end--;
			while (start < end) {
				char c = str[start];
				str[start] = str[end];
				str[end] = c;
				start++;
				end--;
			}
		}
	}
}
