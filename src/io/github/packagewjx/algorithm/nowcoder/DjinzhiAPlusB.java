package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/26.
 * https://www.nowcoder.com/pat/6/problem/4048
 */
public class DjinzhiAPlusB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int D = in.nextInt();
		System.out.println(toDjinzhi(A + B, D));
	}

	public static String toDjinzhi(int num, int D) {
		StringBuilder builder = new StringBuilder(32);
		while (num != 0) {
			builder.insert(0, num % D);
			num /= D;
		}
		return builder.toString();
	}
}
