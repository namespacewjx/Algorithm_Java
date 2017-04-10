package io.github.packagewjx.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 吴俊贤 on 2017/4/5.
 *
 * 可排序和不排序，不排序的话，使用箱排序，非常快，但是非常占空间，排序的话，看这个solution，挺快的了。
 */
public class Problem506 {
	public class Solution {
		public String[] findRelativeRanks(int[] nums) {
			if (nums == null || nums.length == 0) {
				return null;
			}

			Integer[] index = new Integer[nums.length];
			for (int i = 0; i < index.length; i++) {
				index[i] = i;
			}

			String[] result = new String[nums.length];

			//超级明智的做法，如果一个index对应的数要比另一个的大，则这个index更大
			Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

			result[index[0]] = "Gold Medal";
			if (1 < index.length) result[index[1]] = "Silver Medal";
			if (2 < index.length) result[index[2]] = "Bronze Medal";

			for (int i = 3; i < index.length; i++) {
				result[index[i]] = String.valueOf(i + 1);
			}

			return result;
		}
	}

}
