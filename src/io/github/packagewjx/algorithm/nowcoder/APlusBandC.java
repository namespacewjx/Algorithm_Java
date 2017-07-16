package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/24.
 * https://www.nowcoder.com/pat/6/problem/4077
 */
public class APlusBandC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		for (int i = 1; i <= count; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			System.out.println("Case #" + i + ": " + solve(a, b, c));
		}

	}

	public static boolean solve(int a, int b, int c) {
		return a > c - b;
	}
}
