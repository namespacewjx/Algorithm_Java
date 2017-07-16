package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/24.
 * https://www.nowcoder.com/pat/6/problem/4040
 * 这道题真奇怪，说的不清不楚的
 */
public class HolmesDate {

	public static void main(String[] args) {
		//TODO 做题
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		String s3 = in.nextLine();
		String s4 = in.nextLine();
		System.out.println(solve(s1, s2, s3, s4));
	}

	public static final String[] WEEKDAYS = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

	private static String solve(String s1, String s2, String s3, String s4) {
		StringBuilder builder = new StringBuilder(10);
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();




		chars1 = s3.toCharArray();
		chars2 = s4.toCharArray();
		boolean found = false;
		for (int i = 0; i < chars1.length && !found; i++) {
			char c = chars1[i];
			if (!Character.isLetter(c))
				continue;
			for (int j = 0; j < chars2.length; j++) {
				if (chars2[j] == c) {
					if (j < 10) {
						builder.append('0').append(j);
					} else
						builder.append(j);
					found = true;
					break;
				}
			}
		}

		return builder.toString();
	}
}
