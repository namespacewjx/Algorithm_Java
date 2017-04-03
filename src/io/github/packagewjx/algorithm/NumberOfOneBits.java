package io.github.packagewjx.algorithm;

/**
 * Created by 吴俊贤 on 2017/3/3.
 */
public class NumberOfOneBits {
	// you need to treat n as an unsigned value
	public static void main(String[] args) {
		System.out.println(new NumberOfOneBits().hammingWeight(  2));
	}
	public int hammingWeight(int n) {
		int result = 0;
		while (n != 0) {
			if (n % 2 == 1) {
				result++;
			}
			n /= 2;
		}
		return result;
	}
}
