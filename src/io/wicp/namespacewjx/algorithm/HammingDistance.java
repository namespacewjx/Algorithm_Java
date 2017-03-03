package io.wicp.namespacewjx.algorithm;

/**
 * Created by 吴俊贤 on 2017/3/3.
 * 题目网址：https://leetcode.com/problems/hamming-distance/?tab=Description
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int d = 0;
		while (x != 0 && y != 0) {
			if (x % 2 != y % 2) {
				d++;
			}
			x /= 2;
			y /= 2;
		}
		while (x != 0) {
			if (x % 2 == 1) {
				d++;
			}
			x /= 2;
		}
		while (y != 0) {
			if (y % 2 == 1) {
				d++;
			}
			y /= 2;
		}
		return d;

	}
}
