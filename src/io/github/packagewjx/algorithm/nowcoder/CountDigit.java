package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/26.
 * https://www.nowcoder.com/pat/6/problem/4047
 */
public class CountDigit {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] line = in.nextLine().toCharArray();
		int[] count = new int[10];
		for (int i = 0; i < line.length; i++) {
			count[line[i] - '0']++;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				System.out.printf("%d:%d\n", i, count[i]);
		}
	}
}
