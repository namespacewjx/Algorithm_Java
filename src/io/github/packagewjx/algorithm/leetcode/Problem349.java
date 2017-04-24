package io.github.packagewjx.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by 吴俊贤 on 2017/4/22.
 */
public class Problem349 {
	public static void main(String[] args) {
		Solution3 s3 = new Problem349().new Solution3();
		s3.intersection(new int[]{2, 3, 4, 4}, new int[]{3});
	}

	/**
	 * 8ms。使用Java集合类解。
	 */
	public class Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			HashSet<Integer> n1 = new HashSet<>(nums1.length);
			HashSet<Integer> n2 = new HashSet<>(nums2.length);

			for (int i = 0; i < nums1.length; i++) {
				n1.add(nums1[i]);
			}
			for (int i = 0; i < nums2.length; i++) {
				n2.add(nums2[i]);
			}

			n1.retainAll(n2);

			int[] result = new int[n1.size()];
			int index = 0;
			for (Integer integer : n1) {
				result[index++] = integer;
			}

			return result;
		}
	}

	/**
	 * 快了一毫秒，其中一个建集合，另外一个不建
	 */
	public class Solution2 {
		public int[] intersection(int[] nums1, int[] nums2) {
			HashSet<Integer> n1 = new HashSet<>(nums1.length);

			for (int i = 0; i < nums1.length; i++) {
				n1.add(nums1[i]);
			}

			HashSet<Integer> result = new HashSet<>();
			for (int i = 0; i < nums2.length; i++) {
				if (n1.contains(nums2[i])) {
					result.add(nums2[i]);
				}
			}

			int[] ret = new int[result.size()];
			int index = 0;
			for (Integer integer : result) {
				ret[index++] = integer;
			}
			return ret;

		}
	}

	/**
	 * 双指针法，又快了一毫秒
	 */
	public class Solution3 {
		public int[] intersection(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			HashSet<Integer> result = new HashSet<>();

			int p = 0, q = 0;
			while (p < nums1.length && q < nums2.length) {
				if (nums1[p] < nums2[q])
					p++;
				else if (nums1[p] > nums2[q])
					q++;
				else{
					result.add(nums1[p]);
					p++;
					q++;
				}
			}

			int[] ret = new int[result.size()];
			int index = 0;
			for (Integer integer : result) {
				ret[index++] = integer;
			}
			return ret;
		}
	}

	public class Solution4 {
		public int[] intersection(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			HashSet<Integer> result = new HashSet<>();

			for (int i = 0; i < nums2.length; i++) {
				if (Arrays.binarySearch(nums1, nums2[i]) >= 0)
					result.add(nums2[i]);
			}

			int[] ret = new int[result.size()];
			int index = 0;
			for (Integer integer : result) {
				ret[index++] = integer;
			}
			return ret;
		}
	}

	/**
	 * 统计次数法，果然浪费空间效率高，4ms
	 */
	public class Solution5 {
		public int[] intersection(int[] nums1, int[] nums2) {
			if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
				return new int[0];

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < nums1.length; i++) {
				if (nums1[i] > max)
					max = nums1[i];
			}

			int[] hash = new int[max + 1];
			for (int i = 0; i < nums1.length; i++) {
				hash[nums1[i]]++;
			}

			HashSet<Integer> result = new HashSet<>();

			for (int i = 0; i < nums2.length; i++) {
				if (nums2[i] < hash.length && hash[nums2[i]] > 0)
					result.add(nums2[i]);
			}

			int[] ret = new int[result.size()];
			int index = 0;
			for (Integer integer : result) {
				ret[index++] = integer;
			}
			return ret;
		}
	}
}
