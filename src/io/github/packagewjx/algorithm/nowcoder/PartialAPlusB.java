package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/25.
 * https://www.nowcoder.com/pat/6/problem/4042
 */
public class PartialAPlusB {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int DA = in.nextInt();
		int B = in.nextInt();
		int DB = in.nextInt();

		System.out.println(solve(A, DA, B, DB));
	}

	public static int solve(int A, int DA, int B, int DB) {
		return getPA(A, DA) + getPA(B, DB);
	}

	private static int getPA(int A, int DA) {
		int result = 0;
		while (A > 0) {
			if (A % 10 == DA) {
				result = result * 10 + DA;
			}
			A /= 10;
		}
		return result;
	}
}
