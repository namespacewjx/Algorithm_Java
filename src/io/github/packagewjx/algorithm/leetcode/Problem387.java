package io.github.packagewjx.algorithm.leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by 吴俊贤 on 2017/4/24.
 */
public class Problem387 {


	//24ms
	public class Solution {
		public int firstUniqChar(String s) {
			char[] chars = s.toCharArray();
			int[] count = new int[26];
			for (int i = 0; i < chars.length; i++) {
				int c = chars[i] - 'a';
				//由于数组初始化为0，与第0个位置冲突，因此记着下标为i+1
				if (count[c] == 0)
					count[c] = i + 1;
				else
					count[c] = Integer.MAX_VALUE;
			}

			int first = Integer.MAX_VALUE;
			for (int i = 0; i < count.length; i++) {
				if (count[i] != 0 && count[i] < first)
					first = count[i];
			}
			return first == Integer.MAX_VALUE ? -1 : first - 1;
		}
	}

	//双指针法，23ms
	public class Solution2 {
		public int firstUniqChar(String s) {
			if (s == null)
				return -1;

			int p = 0, q = 1;
			boolean[] visited = new boolean[26];
			char[] chars = s.toCharArray();

			while (p < chars.length) {
				q = p + 1;

				while (true) {
					while (q < chars.length && visited[chars[q] - 'a'])
						q++;

					if (q == chars.length)
						return p;

					if (chars[q] == chars[p]) {
						visited[chars[q] - 'a'] = true;
						break;
					}

					q++;
				}

				//更新p
				while (p < chars.length && visited[chars[p] - 'a'])
					p++;
			}

			return -1;
		}
	}


}
