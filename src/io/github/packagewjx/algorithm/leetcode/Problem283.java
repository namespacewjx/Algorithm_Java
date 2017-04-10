package io.github.packagewjx.algorithm.leetcode;

import io.github.packagewjx.algorithm.LinkedList;

/**
 * Created by 吴俊贤 on 2017/4/4.
 */
public class Problem283 {
	public static void main(String[] args) {
		Solution2 solution = new Problem283().new Solution2();

		int[] testInt = new int[]{};
		solution.moveZeroes(testInt);
	}


	//用两个指针记录应填充位置和当前遍历位置的算法，扶再度On
	public class Solution {
		public void moveZeroes(int[] nums) {
			if (nums == null)
				return;

			int pPlace = 0;//记录着下一个数值应该放的位置
			int pCur;//记录着当前到达的位置

			//初始化pPlace为第一个0的位置
			while (pPlace < nums.length && nums[pPlace] != 0)
				pPlace++;

			if (pPlace == nums.length) {
				//若没有0，则直接退出
				return;
			}

			//初始化pCur为pPlace的下一个位置
			pCur = pPlace + 1;
			while (pCur < nums.length) {
				//走到下一个非0的地方，并将这个数字放到pPlace指定的地方
				while (pCur < nums.length && nums[pCur] == 0)
					pCur++;
				if (pCur == nums.length) {
					break;
				}

				nums[pPlace] = nums[pCur];//直接覆盖
				pPlace++;//加1，下一个数放到这里
				pCur++;
			}

			//在后面补上0
			while (pPlace < nums.length) {
				nums[pPlace++] = 0;
			}
		}
	}

	//作弊方法，用一个队列记录着所有的有效数据，然后更改原本数组。
//	更慢了！5ms。可能是数据结构的影响
	public class Solution2 {
		public void moveZeroes(int[] nums) {
			if (nums == null)
				return;

			LinkedList<Integer> numbers = new LinkedList<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0)
					numbers.offer(nums[i]);
			}

			int index;
			for (index = 0; index < nums.length && numbers.size() > 0; index++) {
				nums[index] = numbers.poll();
			}

			for (; index < nums.length; index++) {
				nums[index] = 0;
			}
		}
	}
}
