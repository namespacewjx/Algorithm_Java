package io.github.packagewjx.algorithm;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/3/22.
 */
public class Netease2017SpringTest {
	public static void ProblemOne() {
		Scanner in = new Scanner(System.in);
		int zu = in.nextInt();
		for (int i = 0; i < zu; i++) {
			int n = in.nextInt();
			int k = in.nextInt();

			int[] n1 = new int[n];
			int[] n2 = new int[n];
			for (int j = 0; j < n; j++) {
				n1[j] = in.nextInt();
			}
			for (int j = 0; j < n; j++) {
				n2[j] = in.nextInt();
			}
			int[] nk = new int[2 * n];
			nk = xipai(n1, n2, nk);

			for (int j = 1; j < k; j++) {
				for (int l = 0; l < n; l++) {
					n1[l] = nk[l];
				}
				for (int l = 0; l < n; l++) {
					n2[l] = nk[n + l];
				}
				nk = xipai(n1, n2, nk);
			}

			for (int j = 0; j < 2 * n - 1; j++) {
				System.out.print(nk[j] + " ");
			}
			System.out.println(nk[2 * n - 1]);
		}
	}

	public static int[] xipai(int[] n1, int[] n2, int[] nk) {
		for (int i = 0; i < n1.length; i++) {
			nk[2 * i] = n1[i];
			nk[2 * i + 1] = n2[i];
		}
		return nk;
	}






	public static void ProblemTwo() {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		for (int i = 0; i < k; i++) {
			int n = in.nextInt();
			if (n == 1) {
				System.out.println("1");
				continue;
			}
			RoundQueue queue = new RoundQueue(n);
			int[] array = new int[n];
			int index;
			for (int j = 0; j < n; j++) {
				index = queue.goToNext();
				queue.setTrue();
				array[index] = j + 1;
			}

			for (int j = 0; j < n - 1; j++) {
				System.out.print(array[j] + " ");
			}
			System.out.println(array[n - 1]);
		}
	}

	public static class RoundQueue {
		boolean[] queue;
		int cur;
		int size;
		RoundQueue(int size) {
			queue = new boolean[size];
			this.size =size;
			cur = -1;
		}

		int goToNext() {
			nextFalse();
			return nextFalse();
		}

		int nextFalse() {
			while (queue[cur = ++cur % size]);
			return cur;
		}

		void setTrue() {
			queue[cur] = true;
		}
	}



}
