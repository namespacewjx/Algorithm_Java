package io.wicp.namespacewjx.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by 吴俊贤 on 2017/3/25.
 */
public class Problem496 {
	public static void main(String[] args) {
//		int[] shu = new int[100];
//		for (int i = 0; i < shu.length; i++) {
//			shu[i] = (int) (1000 * Math.random());
//		}

		Solution solution = new Problem496().new Solution();
		int[] findNums = {4, 1, 2};
		int[] nums = {1, 3, 4, 2};
		int[] ints = solution.nextGreaterElement(findNums, nums);
		for (int anInt : ints) {
			System.out.println(anInt);
		}
	}



	public class Solution {
		public int[] nextGreaterElement(int[] findNums, int[] nums) {
			Map<Integer, Integer> map = new HashMap<>(findNums.length);
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < nums.length; i++) {
				if (stack.isEmpty() || stack.peek() >= nums[i]) {
					stack.push(nums[i]);
				} else {
					do {
						map.put(stack.pop(), nums[i]);
					} while (!stack.isEmpty() && stack.peek() < nums[i]);
					stack.push(nums[i]);
				}
			}

			for (int i = 0; i < findNums.length; i++) {
				findNums[i] = map.getOrDefault(findNums[i], -1);
			}
			return findNums;
		}




	}
}
