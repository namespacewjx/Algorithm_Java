package io.wicp.namespacewjx.algorithm;

/**
 * Created by 吴俊贤 on 2017/3/3.
 * 说明，这个算法的方法，不够快，复杂度不符合要求，因此只是看看就好了
 * 原网址：https://leetcode.com/problems/median-of-two-sorted-arrays/?tab=Description
 */
public class MedianOfTwoSortedArrays {


	public static void main(String[] args) {
		int[] nums1 = new int[]{1, 3};
		int[] nums2 = new int[]{2, 4, 5, 6, 7};
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArraysSlow(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//如果其中一个数组为空
		if (nums1.length == 0 || nums2.length == 0) {
			if (nums1.length == 0) {
				nums1 = nums2;
			}
			int medium = nums1.length / 2;
			if (nums1.length % 2 == 1) {
				return nums1[medium];
			} else {
				return (((double) nums1[medium]) + ((double) nums1[medium - 1])) / 2;
			}
		}
		//先处理最简单的情况，两个数组不重合的
		if (nums1[nums1.length - 1] < nums2[0]) {
			return twoSeperateNums(nums1, nums2);
		} else if (nums1[0] > nums2[nums2.length - 1]) {
			return twoSeperateNums(nums2, nums1);
		}




		int k = (nums1.length + nums2.length) / 2;

		if ((nums1.length + nums2.length) % 2 == 0) {
			double n1 = findKNum(nums1, 0, nums1.length, nums2, 0, nums2.length, k);
			double n2 = findKNum(nums1, 0, nums1.length, nums2, 0, nums2.length, k - 1);
			return (n1 + n2) / 2;
		} else {
			return findKNum(nums1, 0, nums1.length, nums2, 0, nums2.length, k);
		}

	}


	public double findKNum(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
		//确保findknum的nums1是元素多的数组
		if (e1 - s1 < e2 - s2) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tempint = s1;
			s1 = s2;
			s2 = tempint;
			tempint = e1;
			e1 = e2;
			e2 = tempint;
		}

		if (e1 - s1 == 1) {
			if (e2 - s2 == 0)
				return nums1[s1];
			if (k == 0)
				return nums1[s1] < nums2[s2] ? nums1[s1] : nums2[s2];
			else
				return nums1[s1] > nums2[s2] ? nums1[s1] : nums2[s2];
		}
		int m1 = (e1 + s1) / 2;
		int im1 = findNumIndex(nums2, nums1[m1], s2, e2);
		int leftNum = m1 + im1 - s1 - s2;


		if (k < leftNum) {
			return findKNum(nums1, s1, m1, nums2, s2, im1, k);
		} else {
			return findKNum(nums1, m1, e1, nums2, im1, e2, k - leftNum);
		}

	}


	/**
	 * 二分搜索递归算法，搜索那个大于等于num的最小的书的最小的下标
	 *
	 * @param nums
	 * @param num   要找的数
	 * @param start 开始元素位置
	 * @param end   超尾元素位置，最后一个元素的后面一个位置
	 * @return 该数的位置，若有这个数，则是这个位置；若这个数大于数组最大值，则为超尾元素位置；若无这个数，则是大于它的最小元素的位置
	 */
	public int findNumIndex(int[] nums, int num, int start, int end) {
		if (start == end) {
			return start;
		}
		if (start + 1 == end) {
			if (num > nums[start])
				return start + 1;
			else
				return start;
		}
		if (start + 2 == end) {
			if (nums[start] >= num)
				return start;
			if (nums[start + 1] < num)
				return end;
			else return start + 1;
		}
		int medium = (end - start) / 2 + start;
		if (nums[medium] < num) {
			start = medium + 1;
			return findNumIndex(nums, num, start, end);
		} else {
			end = medium + 1;
			return findNumIndex(nums, num, start, end);
		}
	}


	/**
	 * 两个有序数组，不重合的，找中位数，时间效率theta1
	 *
	 * @param nums1 较小的数组
	 * @param nums2 较大的数组
	 * @return
	 */
	public double twoSeperateNums(int[] nums1, int[] nums2) {
		int medianIndex = (nums1.length + nums2.length) / 2;
		int remainder = (nums1.length + nums2.length) % 2;
		//在第一个数组中
		if (medianIndex < nums1.length) {
			if (remainder == 1) {
				//这是只有一个中位数的情况
				return nums1[medianIndex];
			} else {
				return ((double) nums1[medianIndex] + (double) nums1[medianIndex - 1]) / 2;
			}
		} else {
			//在第二个数组中
			if (remainder == 1) {
				return nums2[medianIndex - nums1.length];
			} else {
				//要注意，可能还有一个数在前一个数组中
				if (medianIndex - nums1.length == 0) {
					return (((double) nums1[nums1.length - 1]) + ((double) nums2[0])) / 2;
				} else
					return ((double) nums2[medianIndex - nums1.length] + (double) nums2[medianIndex - nums1.length - 1]) / 2;
			}

		}
	}


	public double findMedianSortedArraysSlow(int[] nums1, int[] nums2) {
		int medianIndex = (nums1.length + nums2.length) / 2;
		int remainder = (nums1.length + nums2.length) % 2;

		if (remainder == 0) {
			medianIndex -= 1;
		}

		int p, q, current;
		current = p = q = 0;

		while (current < medianIndex) {
			int a = findNextNumArray(nums1, nums2, p, q);
			if (a == 1) p++;
			if (a == 2) q++;
			if (a == -1) System.out.println("错误！");
			current++;
		}

		int a = findNextNumArray(nums1, nums2, p, q);
		if (remainder == 0) {
			double n1 = 0;
			if (a == 1) {
				n1 = nums1[p];
				p++;
			}
			if (a == 2) {
				n1 = nums2[q];
				q++;
			}

			a = findNextNumArray(nums1, nums2, p, q);
			double n2 = 0;
			if (a == 1) {
				n2 = nums1[p];
			}
			if (a == 2) {
				n2 = nums2[q];
			}

			return (n1 + n2) / 2;

		} else {
			if (a == 1) return nums1[p];
			if (a == 2) return nums2[q];
		}


		return 0;
	}

	/**
	 * 寻找下一个最小的数在哪一个数组中
	 *
	 * @param nums1
	 * @param nums2
	 * @param p1    nums1数组当前数的下标
	 * @param p2    nums2数组当前数的下标
	 * @return -1代表错误，1代表第一个数组，2代表第二个数组
	 */
	private int findNextNumArray(int[] nums1, int[] nums2, int p1, int p2) {
		if (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] < nums2[p2]) {
				return 1;
			} else {
				return 2;
			}
		}

		if (p1 < nums1.length) {
			return 1;
		}
		if (p2 < nums2.length) {
			return 2;
		}
		return -1;
	}
}