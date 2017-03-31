package io.wicp.namespacewjx.algorithm.leetcode;

import java.util.ArrayList;

/**
 * Created by 吴俊贤 on 2017/3/24.
 * <a href:"https://leetcode.com/problems/keyboard-row/#/description">对应问题网址</a>
 */
public class Problem500 {
	public static void main(String[] args) {
		Problem500 problem500 = new Problem500();
		Solution solution = problem500.new Solution();
		String[] words = solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
		for (String word : words) {
			System.out.println(word);
		}
	}
	public class Solution {
		public int[] ZHISHU = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
		public final long[] T = {94647060594524141L, 131011714106L, 18779414295L};

		public String[] findWords(String[] words) {
			ArrayList<String> result = new ArrayList<>(words.length / 2);

			for (int i = 0; i < words.length; i++)  {
				String word = words[i];
				for (long aT : T) {
					boolean flag = true;
					for (int k = 0; k < word.length(); k++) {
						char c = word.charAt(k);
						int index;
						if (c < 'a') {
							index = c - 'A';
						} else
							index = c - 'a';
						if (aT % ZHISHU[index] != 0) {
							flag = false;
							break;
						}
					}
					if (flag) {
						result.add(word);
						break;
					}
				}
			}
			String[] resultS = new String[result.size()];
			result.toArray(resultS);

			return resultS;
		}
	}
}
