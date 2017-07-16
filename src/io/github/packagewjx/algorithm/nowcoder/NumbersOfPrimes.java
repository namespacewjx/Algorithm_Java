package io.github.packagewjx.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/25.
 * https://www.nowcoder.com/pat/6/problem/4079
 */
public class NumbersOfPrimes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		List<Integer> result = solve(M, N);
		for (int i = 0; i < result.size() - 1; i++) {
			System.out.print(result.get(i));
			if (i % 10 == 9)
				System.out.println();
			else
				System.out.print(' ');
		}
		System.out.print(result.get(result.size() - 1));
	}

	public static List<Integer> solve(int M, int N) {
		ArrayList<Integer> result = new ArrayList<>(N);
		result.add(2);
		result.add(3);
		result.add(5);
		for (int i = 6; result.size() < N; i++) {
			boolean isPrime = true;
			for (int j = 0; j < result.size(); j++) {
				if (i % result.get(j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				result.add(i);
		}
		return result.subList(M - 1, N);
	}
}
