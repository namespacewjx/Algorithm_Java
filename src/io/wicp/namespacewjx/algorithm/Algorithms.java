package io.wicp.namespacewjx.algorithm;

import io.wicp.namespacewjx.algorithm.leetcode.Problem496;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 吴俊贤 on 2016/10/13.
 */
public class Algorithms {
	public static void main(String[] args) {
		new Algorithms().majorityElement(new int[]{-1, -1, 2147483647});
	}

	public int majorityElement(int[] nums) {
		//find the max and the min element
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
			if (nums[i] < min) {
				min = nums[i];
			}
		}

		if ((long) max - (long) min > 1024l) {
			Map<Integer, Integer> times = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (times.containsKey(nums[i])) {
					int oldtime = times.remove(nums[i]);
					times.put(nums[i], oldtime + 1);
				} else {
					times.put(nums[i], 1);
				}
			}
			Set<Integer> keys = times.keySet();
			for (Integer i : keys) {
				if (times.get(i) >= nums.length / 2) {
					return i;
				}
			}
		}

		int[] times = new int[max - min + 1];
		for (int i = 0; i < nums.length; i++) {
			times[nums[i] - min]++;
		}

		for (int i = 0; i < times.length; i++) {
			if (times[i] >= (nums.length / 2))
				return min + i;
		}

		return 0;
	}


	public static void quickSort(Comparable[] items, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		if (start + 2 == end) {
			if (items[start].compareTo(items[end - 1]) > 0) {
				swap(items, start, end - 1);
			}
			return;
		}


		Comparable pivot = items[start];
		int i = start + 1;
		int j = end - 1;
		while (i < j) {
			while (i < j && items[i].compareTo(pivot) < 0) {
				i++;
			}
			while (i < j && items[j].compareTo(pivot) > 0) {
				j--;
			}
			swap(items, i, j);
		}
		swap(items, start, i - 1);

		quickSort(items, start, i);
		quickSort(items, j, end);
	}

	public static void swap(Object[] nums, int i1, int i2) {
		Object temp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = temp;
	}


	//TODO 写一个二分搜索算法，参数为comparable



}
