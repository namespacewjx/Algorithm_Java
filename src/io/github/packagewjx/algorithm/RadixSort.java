package io.github.packagewjx.algorithm;

import java.util.Arrays;

/**
 * Created by 吴俊贤 on 2017/4/10.
 * 基数排序类
 */
public class RadixSort {

	//TODO 使用基数16来计算

	public static void main(String[] args) {
		int N = 100000;
		int max = 100000;
		int[] num1 = new int[N];
		int[] num2 = new int[N];
		for (int i = 0; i < N; i++) {
			int n = (int) (Math.random() * max);
			num1[i] = n;
			num2[i] = n;
		}

		long t1 = System.currentTimeMillis();
		Arrays.sort(num1);
		t1 = System.currentTimeMillis() - t1;

		long t2 = System.currentTimeMillis();
		sort(num2);
		t2 = System.currentTimeMillis() - t2;

		System.out.println("T1:" + t1);
		System.out.println("T2:" + t2);

		for (int i = 0; i < N; i++) {
			if (num1[i] != num2[i]) {
				System.out.println("Not Equal");
				break;
			}
		}
	}

	public static void sort(int[] nums) {
		int maxRound = findMaxNumberOfDigits(nums) / 4 + 1;
		int[] count = new int[16];
		int[][] bin = new int[][]{nums, new int[nums.length]};
		int which = 1;//使用bin的哪一个数组放置当前数，而另外一个放置上一次的结果
		int mask = 0xf;

		for (int i = 0; i < maxRound; i++) {
			//统计数目
			for (int j = 0; j < nums.length; j++) {
				count[(bin[1 - which][j] & mask) >> i * 4]++;
			}

			//计算位置，利用前面所有的和，就是当前基数的第一个元素的位置，后面更新一下，就是当前位置
			int sum = count[0];
			count[0] = 0;
			for (int j = 1; j < count.length; j++) {
				int temp = count[j];
				count[j] = sum;
				sum += temp;
			}

			for (int j = 0; j < nums.length; j++) {
				int radix = (bin[1 - which][j] & mask) >> i * 4;
				int index = count[radix];
				bin[which][index] = bin[1 - which][j];

				count[radix]++;//更新下标
			}

			set0(count);
			which = 1 - which;
			mask = mask << 4;
		}

		if (which == 0) {
			for (int i = 0; i < nums.length; i++) {
				nums[i] = bin[1][i];
			}
		}

		return;
	}

	private static void set0(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	//寻找正整数数组中的最大数的最高二进制位位数
	private static int findMaxNumberOfDigits(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
		}

		return Algorithms.highestBinary1Bit(max);
	}
}
