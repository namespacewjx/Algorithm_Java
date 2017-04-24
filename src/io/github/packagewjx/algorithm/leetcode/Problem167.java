package io.github.packagewjx.algorithm.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/10.
 */
public class Problem167 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
	}

	//遇到大量重复元素，就会扑街的算法
	public class Solution {
		public int[] twoSum(int[] numbers, int target) {
			if (numbers == null || numbers.length == 0)
				return null;

//          这是一开始想的，for循环只循环到end，初始化end的步骤，但是没必要，还容易出bug
//			int end = Arrays.binarySearch(numbers, target);
//			if (end < 0)
//				end = -1 * (end + 1);
//			//对于负数的情况，有可能target比第一个元素还小，而前面的元素都是负数才可以得出结果，因此搜索负数时，end设为0的下标
//			else if (end == 0)
//				end = Arrays.binarySearch(numbers, 0);
//			else
//				end = end + 1;//对于找到的情况，需要加1，以解决-1，0得不到结果的问题


			int toIndex = numbers.length;
			for (int i = 0; i < numbers.length; i++) {
				int i1 = Arrays.binarySearch(numbers, i + 1, toIndex, target - numbers[i]);
				if (i1 > i)
					return new int[]{i + 1, i1 + 1};
				else if (i1 == i)//i1 = i表明结果在i，因为前面已经遍历过，因此退出
					break;
				else if (i1 < 0)
					i1 = -1 * (i1 + 1);

				toIndex = i1;//其实！toIndex可以每次更新，提升搜索效率！

				//TODO 优化，当大量重复元素出现的时候，就更新i。这个优化还不行！
				if (i + 1 < numbers.length && numbers[i + 1] == numbers[i]) {
					i = Arrays.binarySearch(numbers, i + 1, toIndex, numbers[i] + 1);
					i = i > 0 ? i : -1 * (i + 1);
				}
			}

			return null;
		}
	}


}
