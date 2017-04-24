package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/15.
 */
public class Problem383 {

	//常规解法，计算出现次数，22ms
	public class Solution {
		public boolean canConstruct(String ransomNote, String magazine) {
			int[] ran = letterCount(ransomNote);
			int[] mag = letterCount(magazine);
			for (int i = 0; i < ran.length; i++) {
				if (ran[i] > mag[i])
					return false;
			}
			return true;
		}

		/**
		 * 计算string里面各个小写字母的出现个数
		 * @param string 要计算的字符串
		 * @return 包含26个元素的int数组，包含着26个小写字母的出现次数
		 */
		public int[] letterCount(String string) {
			if (string == null || string.length() == 0)
				return new int[26];
			char[] chars = string.toCharArray();
			int[] result = new int[26];
			for (char c : chars) {
				result[c - 'a']++;
			}
			return result;
		}
	}





}
