package io.github.packagewjx.algorithm.leetcode;

/**
 * Created by 吴俊贤 on 2017/3/28.
 */
public class Problem463 {
	public static void main(String[] args) {
		System.out.println(new Problem463().new Solution2().islandPerimeter(new int[][]{{0, 1, 0, 0},
				{1, 1, 1, 0},
				{0, 1, 0, 0},
				{1, 1, 0, 0}}));
	}

	public class Solution2 {
		public int islandPerimeter(int[][] grid) {
			int[][] linjie = new int[grid.length][grid[0].length];
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 1) {
						if (i - 1 >= 0)
							linjie[i - 1][j]++;
						if (i + 1 < grid.length)
							linjie[i + 1][j]++;
						if (j - 1 >= 0)
							linjie[i][j - 1]++;
						if (j + 1 < grid[0].length)
							linjie[i][j + 1]++;
					}
				}
			}

			int result = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 1) {
						result += 4 - linjie[i][j];
					}
				}
			}
			return result;
		}
	}

	public class Solution1 {
		public static final int WATER = 0;
		public static final int VISITED = 2;

		public int islandPerimeter(int[][] grid) {
			int x, y;
			x = y = 0;
			//首先找到最上面，最左边的点
			boolean found = false;
			for (; x < grid.length; x++) {
				for (y = 0; y < grid[0].length; y++) {
					if (grid[x][y] == 1) {
						found = true;
						break;
					}
				}
				if (found) {
					break;
				}
			}

			//开始递归
			return traverse(grid, x, y);
		}

		public int traverse(int[][] grid, int x, int y) {
			//判断是否越界
			if (x < 0 || x >= grid.length)
				return 1;
			if (y < 0 || y >= grid[0].length)
				return 1;

			//判断是否为海
			if (grid[x][y] == WATER)
				return 1;

			if (grid[x][y] == VISITED) {
				return 0;
			}
			grid[x][y] = VISITED;


			//都不是，则为岛屿点，然后访问周围节点
			int result = 0;//从这个点开始的
			result += traverse(grid, x - 1, y);
			result += traverse(grid, x + 1, y);
			result += traverse(grid, x, y - 1);
			result += traverse(grid, x, y + 1);
			return result;
		}
	}
}