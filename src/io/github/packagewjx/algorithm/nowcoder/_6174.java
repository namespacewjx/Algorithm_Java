package io.github.packagewjx.algorithm.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/25.
 * https://www.nowcoder.com/pat/6/problem/4045
 */
public class _6174 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		int a, b;

		do {
			int[] digits = getNumDigit(c);
			Arrays.sort(digits);
			a = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];
			b = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
			c = a - b;
			printLn(a, b, c);
		} while (c != 6174 && c != 0);
	}

	public static void printLn(int a, int b, int c) {
		System.out.printf("%04d - %04d = %04d\n", a, b, c);
	}

	public static int[] getNumDigit(int num) {
		int[] digit = new int[4];
		digit[0] = num / 1000;
		digit[3] = num % 10;
		digit[2] = (num % 100 - digit[3]) / 10;
		digit[1] = num / 100 - digit[0] * 10;
		return digit;
	}





}
