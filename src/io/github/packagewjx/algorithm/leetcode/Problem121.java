package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/6.
 */
public class Problem121 {

	public class Solution {
		public int maxProfit(int[] prices) {
			if (prices == null || prices.length <= 1) {
				return 0;
			}

			int[] sum = new int[prices.length];
			int biggest = 0;
			for (int i = 1; i < prices.length; i++) {
				if (sum[i - 1] <= 0)
					sum[i] = prices[i] - prices[i - 1];
				else
					sum[i] = prices[i] - prices[i - 1] + sum[i - 1];

				if (sum[i] > biggest)
					biggest = sum[i];
			}

			return biggest;
		}
	}


}
