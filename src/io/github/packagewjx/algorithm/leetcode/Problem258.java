package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/1.
 */
public class Problem258 {
	public static void main(String[] args) {
		int[] test = new int[]{534251, 514, 1, 0, 0x7fffffff, 1879048191, 327679};
		Solution solution = new Problem258().new Solution();
		for (int i : test) {
			System.out.println(solution.addDigits(i));
		}
	}
	public class Solution {
		public int addDigits(int num) {
			int a = num / 100000;
			int b = num - a * 100000;
			num = a + b;

			a = num / 1000;
			b = num - a * 1000;
			num = a + b;

			a = num / 100;
			b = num - a * 100;
			num = a + b;

			a = num / 10;
			b = num - a * 10;
			num = a + b;

			a = num / 10;
			b = num - a * 10;
			num = a + b;

			return num;
		}
	}
}
