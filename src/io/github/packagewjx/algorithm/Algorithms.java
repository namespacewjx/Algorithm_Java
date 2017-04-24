package io.github.packagewjx.algorithm;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by 吴俊贤 on 2016/10/13.
 */
public class Algorithms {
	public static void main(String[] args) {
		System.out.println(Algorithms.highestBinary1Bit(-0x2));
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


	/**
	 * 是否还有下一个排列的全局变量
	 */
	public static boolean hasNextPermutation;

	/**
	 * 生成n的全排列字典序算法
	 * @param n 排列数n
	 * @return 包含字典序排列结果的ArrayList
	 */
	public static ArrayList<int[]> LexicographicPermute(int n) {
		//大于12的全排列暂且不做
		if (n > 12)
			return new ArrayList<>(0);

		ArrayList<int[]> result = new ArrayList<>(factorial(n));

		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i + 1;
		}
		while (hasNextPermutation) {
			result.add(p);
			p = nextLexicographicPermute(p);
		}

		return result;
	}

	/**
	 * 返回下一个字典序的排列，若无下一个排列，则hasNextPermutation会设置为false
	 * @param p
	 * @return
	 */
	public static int[] nextLexicographicPermute(int[] p) {
		int i = p.length - 2;
		hasNextPermutation = true;

		//找到最长递归后缀，出循环后，要么i是最长递归后缀的前一个，要么i为0
		while (i >= 0 && p[i] > p[i + 1])
			i--;
		if (i == -1) {
			hasNextPermutation = false;
			return p;
		}

		//找到最长递归后缀中，比pi要大的最小元素
		int j = p.length - 1;
		while (j > i && p[j] < p[i])
			j--;

		//新建一个数组，保存结果
		int[] result = new int[p.length];
		for (int k = 0; k < i; k++) {
			result[k] = p[k];
		}
		result[i] = p[j];
		for (int k = p.length - 1; k > i; k--) {
			result[p.length - k + i] = p[k];//将后面的逆序调换
		}
		result[p.length - j + i] = p[i];//因为要交换顺序原本i和j中的数字，因此必须在复制后面数组的时候换过来
		return result;
	}

	/**
	 * 交换函数，交换nums数组中i1和i2对应的元素
	 * @param nums 要交换的数组
	 * @param i1 第一个数的下标
	 * @param i2 第二个数的下标
	 */
	public static void swap(int[] nums, int i1, int i2) {
		if (i1 >= nums.length || i1 < 0 || i2 >= nums.length || i2 < 0)
			return;

		nums[i1] = nums[i1] + nums[i2];
		nums[i2] = nums[i1] - nums[i2];
		nums[i1] = nums[i1] - nums[i2];
	}

	/**
	 * 阶乘，注意溢出，肯定不可能乘很大
	 * @param n 阶乘次数
	 * @return 阶乘结果。大于12就溢出，返回0x7fffffff。
	 */
	public static int factorial(int n) {
		if (n < 0)
			return 0;
		if (n <= 1)
			return 1;
		if (n > 12)
			return Integer.MAX_VALUE;

		int result = 1;
		while (n > 1)
			result *= n--;
		return result;
	}


	/**
	 * 使用大数类做阶乘，可以支持非常大的数了
	 * @param n 阶乘数
	 * @return 阶乘结果
	 */
	public static BigDecimal factorial(BigDecimal n) {
		if (n.compareTo(BigDecimal.ZERO) < 0)
			return BigDecimal.ZERO;
		if (n.compareTo(BigDecimal.ONE) <= 0)
			return BigDecimal.ONE;

		BigDecimal result = BigDecimal.ONE;
		while (n.compareTo(BigDecimal.ONE) > 0) {
			result = result.multiply(n);
			n = n.subtract(BigDecimal.ONE);
		}
		return result;
	}

	/**
	 * 二进制格雷码生成算法
	 * @param n 生成格雷码位数
	 * @return 按顺序的格雷码数组
	 */
	public static List<Integer> BRGC(int n) {
		if (n == 1) {
			ArrayList<Integer> result = new ArrayList<>();
			result.add(0);
			result.add(1);
			return result;
		} else if (n > 1 && n < 32) {
			List<Integer> list1 = BRGC(n - 1);
			List<Integer> list2 = new ArrayList<>(list1.size());
			for (int i = list1.size() - 1; i >= 0; i--) {
				int num = list1.get(i);
				num |= (1 << n - 1);
				list2.add(num);
			}
			list1.addAll(list2);
			return list1;
		} else
			return new ArrayList<>(0);
	}


	/**
	 * 计算二进制数中最高位1的位置
	 * @param num 要计算的数
	 * @return 最高位1所在的位数，最低一位是0，最高位31
	 */
	public static int highestBinary1Bit(int num) {
		if (num == 0)
			return -1;

		int result = 0;
		if (num >>> 16 > 0) {
			result += 16;
			num >>>= 16;
		}
		if (num >>> 8 > 0) {
			result += 8;
			num >>>= 8;
		}
		if (num >>> 4 > 0) {
			result += 4;
			num >>>= 4;
		}
		if (num >>> 2 > 0) {
			result += 2;
			num >>>= 2;
		}
		return (num & 2) == 2 ? result + 1 : result;
	}

}
