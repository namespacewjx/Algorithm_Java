package io.github.packagewjx.algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by 吴俊贤 on 2017/4/13.
 */
public class Problem455 {

	public static void main(String[] args) {
		Solution solution = new Problem455().new Solution();
		System.out.println(solution.findContentChildren(new int[]{3, 7, 8}, new int[]{1, 6, 8}));
	}

	//使用贪婪法？每次取出一个满意阈值最小的人，给他曲奇。
	//啊看错了，原题目不允许一次给小孩子两块曲奇
	public class Solution {
		public int findContentChildren(int[] g, int[] s) {
			if (g == null || null == s || g.length == 0 || s.length == 0)
				return 0;

			//使用优先队列来存下一个最小的小孩，每次取出，用下一块最小的曲奇满足他
			PriorityQueue<Integer> children = new PriorityQueue<>(g.length);
			for (int i = 0; i < g.length; i++) {
				children.add(g[i]);
			}

			Arrays.sort(s);

			int contentChildCount = 0;
			for (int currentCookie = 0; currentCookie < s.length; currentCookie++) {
				int currentChild = children.poll();
				currentChild -= s[currentCookie];
				if (currentChild <= 0) {
					contentChildCount++;
				} else
					children.offer(currentChild);
			}
			return contentChildCount;
		}
	}

	//重新再做一次。每次看最小的小孩，然后选最小的能满足他的曲奇饼给他，就行了
	public class Solution2 {
		public int findContentChildren(int[] g, int[] s) {
			Arrays.sort(g);
			Arrays.sort(s);

			int currentCookie = 0;
			int count = 0;
			for (int i = 0; i < g.length; i++) {
				while (currentCookie < s.length && g[i] > s[currentCookie])
					currentCookie++;
				if (currentCookie == s.length)
					return count;//曲奇没了，返回结果
				count++;
				currentCookie++;//这个曲奇给他了，检查下一个
			}
			return count;
		}
	}
}
