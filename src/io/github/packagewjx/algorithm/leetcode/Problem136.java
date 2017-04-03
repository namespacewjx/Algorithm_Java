package io.github.packagewjx.algorithm.leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by 吴俊贤 on 2017/3/30.
 */
public class Problem136 {
	public static void main(String[] args) {
		System.out.println(new Problem136().new Solution2().singleNumber(new int[]{1, 1, 2, 2, 3, 4, 4}));
	}

	//超级简单的位操作，异或算法
	public class Solution1 {
		public int singleNumber(int[] nums) {
			int result = 0;
			for (int i : nums)
				result ^= i;
			return result;
		}
	}

	//普通的Hash Table算法
	public class Solution2 {
		public int singleNumber(int[] nums) {
			HashMap<Integer, Integer> map = new HashMap<>(nums.length / 2 + 1);
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					map.remove(nums[i]);
				} else {
					map.put(nums[i], 1);
				}
			}
			Set<Integer> integers = map.keySet();
			int result = 0;
			for (Integer integer : integers) {
				result = integer;
			}
			return result;
		}
	}
}
