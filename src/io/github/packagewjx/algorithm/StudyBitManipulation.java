package io.github.packagewjx.algorithm;

/**
 * Created by 吴俊贤 on 2017/4/2.
 */
public class StudyBitManipulation {
	public  static void main(String[] args) {
		System.out.println(largestPower(0x7fffffff));
	}
	static long largestPower(long N) {
		N = N | (N >> 1);
		N = N | (N >> 2);
		N = N | (N >> 4);
		N = N | (N >> 8);
		N = N | (N >> 16);
		return (N + 1) >> 1;
	}
}
