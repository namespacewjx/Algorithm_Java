package io.wicp.namespacewjx.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴俊贤 on 2017/3/30.
 */
public class Problem448 {

	public static void main(String[] args) {
		new Problem448().new Solution2().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
	}

	//这个时间很快，但是多用一倍空间
	public class Solution1 {
		public List<Integer> findDisappearedNumbers(int[] nums) {
			int[] count = new int[nums.length];
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < nums.length; i++) {
				count[nums[i] - 1]++;
			}
			for (int i = 0; i < count.length; i++) {
				if (count[i] == 0) {
					list.add(i + 1);
				}
			}
			return list;
		}
	}

	//自己想到的不需要额外空间的算法，把数字放回原本的位置，慢一点
	public class Solution2 {
		public List<Integer> findDisappearedNumbers(int[] nums) {
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != i + 1) {
					int j = nums[i];//先存着当前位置的数
					int k = nums[j - 1];//存着要调出来的位置的数
					while (k != j) {
						nums[j - 1] = j;
						if (k == i + 1)
							break;
						j = k;
						k = nums[j - 1];
					}
					nums[i] = k;
				}
			}

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != i + 1) {
					list.add(i + 1);
				}
			}
			return list;
		}
	}
}
