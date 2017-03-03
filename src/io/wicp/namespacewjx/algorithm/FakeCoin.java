package io.wicp.namespacewjx.algorithm;

public class FakeCoin {

	public static int FakeCoin(int[] coins) {
		return check(coins, 0, coins.length);
	}

	public static int check(int[] coins, int l, int r) {
		if ((r - l) % 3 <= 1) {
			int n = (r - l) / 3;
			int d = compare(coins, l, l + n, n);
			if (d == 0)
				return check(coins, l + 2 * n, r);
			else if (d > 0)
				return check(coins, l, l + n);
			else 
				return check(coins, l + n, l + 2 * n);
		}
		else {
			int n = (r - l) / 3 + 1;
		}
		return 0;
	}

	public static int compare(int[] coins, int c1, int c2, int n) {
		int sum1 = 0;
		for (int i = c1; i < c1 + n; i++) {
			sum1 += coins[i];
		}
		int sum2 = 0;
		for (int i = c2; i < c2 + n; i++) {
			sum2 += coins[i];
		}
		return sum2 - sum1;
	}
}
