package io.github.packagewjx.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴俊贤 on 2017/3/25.
 * <a href="https://leetcode.com/problems/fizz-buzz/#/description">试题网址</a>
 */
public class Problem412 {
	public static void main(String[] args) {
		new Problem412().new Solution().fizzBuzz(1);
	}
	public class Solution {
		public List<String> fizzBuzz(int n) {
			return way1(n);
		}

		public List<String> way1(int n) {
			ArrayList<String> result = new ArrayList<>(n);
			for (int i = 1; i <= n; i++) {
				String s;
				boolean b1 = i % 3 == 0;
				boolean b2 = i % 5 == 0;
				if (b1 && b2) {
					s = "FizzBuzz";
				}
				else if (b1) {
					s = "Fizz";
				} else if (b2) {
					s = "Buzz";
				} else
					s = String.valueOf(i);
				result.add(s);
			}
			return result;
		}
	}
}
