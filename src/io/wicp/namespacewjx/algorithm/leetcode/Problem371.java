package io.wicp.namespacewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/4/1.
 */
public class Problem371 {
	public static void main(String[] args) {
		System.out.println(new Problem371().new Solution().getSum(0x7fffffff, 0x7fffffff));
	}

	public class Solution {
		public int getSum(int a, int b) {
			int c = 0;//进位
			int x = 0;//a中的一位
			int y = 0;//b中的一位
			int sum = 0;//s中的一位
			int one = 1;
			//一位一位运算，然后左移s，加上这一位的结果
			while (a != 0 && b != 0) {
				x = a & 1;
				y = b & 1;
				if ((x ^ y ^ c) == 1)
					sum |= one;

				//更新各个数据
				c = x & c | y & c | x & y;
				a >>>= 1;
				b >>>= 1;
				one <<= 1;
			}

			if (b != 0)
				a = b;
			while (a != 0) {
				x = a & 1;
				if ((x ^ c) == 1)
					sum |= one;

				c = x & c;
				a >>>= 1;
				one <<= 1;
			}
			if (c > 0) {
				sum |= one;
			}

			return sum;
		}
	}
}
