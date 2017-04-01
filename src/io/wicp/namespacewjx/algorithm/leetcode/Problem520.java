package io.wicp.namespacewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/3/31.
 */
public class Problem520 {
	public static void main(String[] args) {
		new Problem520().new Solution2().detectCapitalUse("G");
	}

	//这个solution只要30ms
	public class Solution {
		public boolean detectCapitalUse(String word) {
			if (Character.isUpperCase(word.charAt(0)))
				word = word.substring(1);
			char max, min;
			max = Character.MIN_VALUE;
			min = Character.MAX_VALUE;
			for (int i = 0; i < word.length(); i++) {
				char cur = word.charAt(i);
				if (cur > max)
					max = cur;
				if (cur < min)
					min = cur;
			}
			if ((max <= 'Z' && min >= 'A') || (max <= 'z' && min >= 'a'))
				return true;
			return false;
		}
	}

	//这个solution要36ms
	public class Solution2 {
		public boolean detectCapitalUse(String word) {
			if (word.length() == 1)
				return true;
			if (Character.isUpperCase(word.charAt(0)))
				word = word.substring(1);
			boolean isUpperCase;
			isUpperCase = Character.isUpperCase(word.charAt(0));

			for (int i = 1; i < word.length(); i++) {
				if (Character.isUpperCase(word.charAt(i)) != isUpperCase)
					return false;
			}
			return true;
		}
	}

	//还可以有用正则表达式的，慢死了
    //还有算大写字符数量的，也比我的慢
}
