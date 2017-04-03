package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/2.
 */
public class Problem492 {
	public static void main(String[] args) {
		int[] s = new Problem492().new Solution().constructRectangle(0x7fffffff);
		System.out.println(s[0]);
		System.out.println(s[1]);
	}

	//擦，把a往右走居然会慢很多！
	public class Solution {
		public int[] constructRectangle(int area) {
			int sqrt = (int) Math.sqrt(area);
			if (sqrt * sqrt == area) {
				return new int[]{sqrt, sqrt};
			}
			int a = sqrt;
			for (; area % a != 0; a--) {

			}

			return new int[]{area / a, a};
		}
	}
}
