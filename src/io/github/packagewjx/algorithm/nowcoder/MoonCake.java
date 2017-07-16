package io.github.packagewjx.algorithm.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/25.
 * https://www.nowcoder.com/pat/6/problem/4046
 */
public class MoonCake {
	//TODO 这个程序还有问题
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfKind = in.nextInt();
		int need = in.nextInt();
		int[] stock = new int[numberOfKind];
		double[] price = new double[numberOfKind];
		for (int i = 0; i < numberOfKind; i++) {
			stock[i] = in.nextInt();
		}
		for (int i = 0; i < numberOfKind; i++) {
			price[i] = ((double) in.nextInt()) / stock[i];
			System.out.println(i);
		}
		System.out.printf("%.2f", solve(numberOfKind, need, stock, price));
	}

	/**
	 * 整个方法就是算出最高单价的月饼，然后依次卖出高价月饼
	 * @param numberOfKind
	 * @param need
	 * @param stock
	 * @param price
	 * @return
	 */
	public static double solve(int numberOfKind, int need, int[] stock, final double[] price) {
		double result = 0;

		Integer[] priceRank = new Integer[numberOfKind];
		for (int i = 0; i < numberOfKind; i++) {
			priceRank[i] = i;
		}
		Arrays.sort(priceRank, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return price[o2] - price[o1] > 0f ? 1 : -1;
			}
		});
		int i = 0;
		int kind = priceRank[i];
		for (; i < numberOfKind; i++) {
			kind = priceRank[i];
			if (stock[kind] < need) {
				need -= stock[kind];
				result += price[kind] * stock[kind];
			} else
				break;
		}
		result += price[kind] * need;
		return result;
	}
}
