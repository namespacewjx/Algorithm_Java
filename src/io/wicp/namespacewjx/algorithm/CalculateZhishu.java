package io.wicp.namespacewjx.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/3/26.
 */
public class CalculateZhishu {
	public static void main(String[] args) {
		int size = 5000000;

		new Scanner(System.in).nextLine();

		long T1 = 0;
		for (int i = 0; i < 10; i++) {
			long t1 = System.currentTimeMillis();
			calZhiShu1(size);
			T1 += System.currentTimeMillis() - t1;
			System.out.println(T1);
		}
		T1 /= 10;

		long T2 = 0;
		for (int i = 0; i < 10; i++) {
			long t2 = System.currentTimeMillis();
			calZhiShu2(size);
			T2 += System.currentTimeMillis() - t2;
			System.out.println(T2);
		}
		T2 /= 10;

		long T3 = 0;
		for (int i = 0; i < 10; i++) {
			long t3 = System.currentTimeMillis();
			calZhiShu3(size);
			T3 += System.currentTimeMillis() - t3;
			System.out.println(T3);
		}
		T3 /= 10;

		System.out.println(T1);
		System.out.println(T2);
		System.out.println(T3);
	}


	public static List<Integer> calZhiShu1(int N) {
		ArrayList<Integer> zhiList = new ArrayList<>();
		for (int i = 2; i < N; i++) {
			boolean isZhishu = true;//指示如果下面循环j都遍历过了，就是质数
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isZhishu = false;
					break;
				}
			}
			if (isZhishu) {
				zhiList.add(i);
			}
		}
		return zhiList;
	}

	public static List<Integer> calZhiShu2(int N) {
		ArrayList<Integer> zhiList = new ArrayList<>();
		//先加入初始质数
		zhiList.add(2);
		zhiList.add(3);
		for (int i = 4; i < N; i++) {
			int sqrt = (int) Math.sqrt(i);
			boolean isZhishu = true;
			for (int j = 0; j < zhiList.size(); j++) {
				int z = zhiList.get(j);
				if (z > sqrt)//检验是否大于平方根
					break;

				if (i % z == 0) {
					isZhishu = false;
					break;
				}
			}
			if (isZhishu) {
				zhiList.add(i);
			}
		}
		return zhiList;
	}

	public static List<Integer> calZhiShu3(int N) {
		boolean[] num = new boolean[N];
//		int count = 1;//用于计算有多少个非质数，初始化为1是因为不把1算质数
		num[0] = true;//1不算到质数里面
		for (int i = 1; i < N / 2; i++) {
			for (int j = 2 * i + 1; j < N; j += i + 1) {
//				if (!num[j]){
//					//如果原本位置为false才加，避免重复加
//					count++;
//				}
				num[j] = true;
			}
		}

//		ArrayList<Integer> zhiList = new ArrayList<>(N - count);
		ArrayList<Integer> zhiList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (!num[i])
				zhiList.add(i + 1);
		}
		return zhiList;
	}


}
