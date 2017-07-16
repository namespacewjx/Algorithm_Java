package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/27.
 * https://www.nowcoder.com/pat/6/problem/4049
 */
public class FormASmallestNumber {

	public static void main(String[] args) {
		int[] digits = new int[10];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			digits[i] = in.nextInt();
		}

		System.out.println(solve(digits));
	}

	public static String solve(int[] digits) {
		StringBuilder builder = new StringBuilder();
		//首先放最小的数在前面
		for (int i = 1; i < digits.length; i++) {
			if (digits[i] != 0) {
				digits[i]--;
				builder.append(i);
				break;
			}
		}

		//依次填入最小数
		for (int i = 0; i < digits.length; i++) {
			for (int j = 0; j < digits[i]; j++) {
				builder.append(i);
			}
		}

		return builder.toString();
	}
}
