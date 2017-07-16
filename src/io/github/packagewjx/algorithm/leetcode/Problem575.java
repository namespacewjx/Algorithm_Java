package io.github.packagewjx.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by 吴俊贤 on 2017/7/16.
 * Distribute Candies
 * https://leetcode.com/problems/distribute-candies/#/description
 */
public class Problem575 {
	public static void main(String[] args) {
		Solution solution = new Problem575().new Solution();
		solution.distributeCandies(new int[]{1, 2, 3, 3, 3, 4, 4, 5});
	}

	//数有多少种糖果，先每种只拿一个，如果数量多于一半，则返回一半，否则返回现在的数量。
	public class Solution {
		public int distributeCandies(int[] candies) {
			Arrays.sort(candies);
			int kindCount = 1;
			int lastKind = candies[0];
			for (int i = 1; i < candies.length; i++) {
				if (candies[i] == lastKind)
					continue;
				kindCount++;
				lastKind = candies[i];
			}
			if (kindCount > candies.length / 2)
				return candies.length / 2;
			return kindCount;
		}
	}

	public class Solution1 {
		public int distributeCandies(int[] candies) {
			HashSet<Integer> integers = new HashSet<>();
			for (int candy : candies) {
				integers.add(candy);
			}
			return integers.size() > candies.length / 2 ? candies.length / 2 : integers.size();
		}
	}

}
