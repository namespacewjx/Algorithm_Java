package io.github.packagewjx.algorithm.leetcode;

import io.github.packagewjx.algorithm.LinkedList;

import java.util.Queue;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-8-27
 * 描述： 01 Matrix:https://leetcode.com/problems/01-matrix/description/
 **/
public class Problem542 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        matrix = new Problem542().new Solution().updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    //别人的解法，我复制过来，讲解下
    //具体思路就是，首先从0的地方开始广度遍历搜索，搜索周围4个点，queue.offer(new int[] {i, j});如果那4个点中，某一个的当前距离，
    // 比从这个点的距离+1要大，那么更新那个
    //点的距离，并把他加入到广度遍历的下一个节点中，因为他周围的点，可能也需要根据这个最新结果更新一次。只有更新的点，会放入到搜索队列中，
    //因此，不会造成无穷的循环
    //根据能够终止的条件，加入到广度遍历队列中，不会造成栈溢出了。
    public class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    } else {
                        matrix[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if (r < 0 || r >= m || c < 0 || c >= n ||
                            matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                    queue.add(new int[]{r, c});
                    matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
                }
            }

            return matrix;
        }
    }
}