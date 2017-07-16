package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/25.
 */
public class ShitouJiandaoBu {
	public static final int BU = 0;
	public static final int CHUIZI = 1;
	public static final int JIANDAO = 2;
	public static final String[] CHU = {"B", "C", "J"};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		int[] Acount = new int[3];//储存A的胜平负数
		int[] Achu = new int[3];//储存A胜局时出的东西
		int[] Bchu = new int[3];

		for (int i = 0; i < n; i++) {
			String line = in.nextLine();
			int a = toChu(line.charAt(0));
			int b = toChu(line.charAt(2));
			switch (judge(a, b)) {
				case 0:
					Acount[1]++;
					break;
				case 1:
					Acount[0]++;
					Achu[a]++;
					break;
				case -1:
					Acount[2]++;
					Bchu[b]++;
					break;
			}
		}

		System.out.printf("%d %d %d\n", Acount[0], Acount[1], Acount[2]);
		System.out.printf("%d %d %d\n", Acount[2], Acount[1], Acount[0]);

		int biggest = 0;
		for (int i = 1; i < 3; i++) {
			if (Achu[i] > Achu[biggest])
				biggest = i;
		}
		System.out.print(CHU[biggest] + " ");

		biggest = 0;
		for (int i = 1; i < 3; i++) {
			if (Bchu[i] > Bchu[biggest])
				biggest = i;
		}
		System.out.print(CHU[biggest]);
	}

	/**
	 * 判断石头剪刀布的胜负，1代表a赢b，0代表平局，-1代表b赢a
	 * @param a 出的东西，是BU,CHUIZI,JIANDAO之一
	 * @param b
	 * @return
	 */
	private static int judge(int a, int b) {
		if (a == b)
			return 0;
		if ((a + 1) % 3 == b)
			return 1;
		return -1;
	}

	private static int toChu(char c) {
		switch (c) {
			case 'B':
				return BU;
			case 'C':
				return CHUIZI;
			case 'J':
				return JIANDAO;
			default:
				return 2;
		}
	}
}
