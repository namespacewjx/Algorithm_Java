package io.github.packagewjx.algorithm;

import java.util.*;

/**
 * Created by 吴俊贤 on 2017/5/20.
 */
public class IQiyiCompetition {
}

class p4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		in.nextLine();
		while (!(n == 0 && m == 0)) {
			char[][] puzzle = new char[n][m];
			for (int i = 0; i < n; i++) {
				puzzle[i] = in.nextLine().toCharArray();
			}
			System.out.println(solve(puzzle));
			n = in.nextInt();
			m = in.nextInt();
			in.nextLine();
		}
	}

	static int count;

	public static int solve(char[][] puzzle) {
		count = 0;
		boolean[][] visited = new boolean[puzzle.length][puzzle[0].length];
		traverse(puzzle.length - 1, 0, puzzle, visited);
		return count;
	}

	public static void traverse(int x, int y, char[][] puzzle, boolean[][] visited) {
		if (x == puzzle.length - 1 && y == puzzle[0].length - 1) {
			count++;
			return;
		}

		if (x < 0 || y < 0 || x >= puzzle.length || y >= puzzle[0].length || puzzle[x][y] == '#' || visited[x][y])
			return;

		visited[x][y] = true;

		traverse(x + 1, y, puzzle, visited);
		traverse(x - 1, y, puzzle, visited);
		traverse(x, y + 1, puzzle, visited);
		traverse(x, y - 1, puzzle, visited);

		visited[x][y] = false;
	}
}


class p1 {
	static Map<Integer, Integer>[] maps;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int yusuan = in.nextInt();
		String[] numStr = in.nextLine().split(" ");
		int n = numStr.length / 2;
		int[] P = new int[n];
		int[] V = new int[n];
		for (int i = 1; i < numStr.length; i += 2) {
			P[i / 2] = Integer.parseInt(numStr[i]);
			V[i / 2] = Integer.parseInt(numStr[i + 1]);
		}
		maps = new Map[n];
		for (int i = 0; i < n; i++) {
			maps[i] = new HashMap<>();
		}
		System.out.println(func(n - 1, yusuan, P, V));
	}


	/**
	 * @param i 现在选到第几个节目，0为第一个节目
	 * @param m 当前的花费
	 * @return
	 */
	public static int func(int i, int m, int[] P, int[] V) {
		if (i == -1)
			return 0;
		if (m == 0)
			return 0;
		Integer max = maps[i].get(m);
		if (max == null) {
			if (m - P[i] >= 0) {
				max = Math.max(func(i - 1, m, P, V), func(i - 1, m - P[i], P, V) + V[i]);
			} else
				max = func(i - 1, m, P, V);
			maps[i].put(m, max);
		}
		return max;
	}
}


class p3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		java.util.LinkedList<Integer> points = new java.util.LinkedList<>();
		points.add(1);
		for (int i = 0; i < n; i++) {
			points.add(in.nextInt());
		}
		points.add(1);

		if (n == 0) {
			System.out.println(0);
			return;
		}
		if (n == 1) {
			System.out.println(points.get(1));
			return;
		}

		int sum = 0;
		for (int i = 0; i < n - 2; i++) {
			int maxPoint = 0;
			Set<Integer> maxPositions = new HashSet<>(10);//存着所有最大位置，可能有多个，因此必须用集合存起来，最后去除pos最小的那个
			Iterator<Integer> iterator = points.iterator();
			int i1 = iterator.next();
			int i2 = iterator.next();
			int i3;
			for (int j = 1; j < points.size() - 1; j++) {
				i3 = iterator.next();
				int curPoint = i1 * i2 * i3;
				if (curPoint > maxPoint) {
					maxPositions.clear();
					maxPositions.add(j);
					maxPoint = curPoint;
				} else if (curPoint == maxPoint) {
					maxPositions.add(j);
				}
				i1 = i2;
				i2 = i3;
			}
			sum += maxPoint;
			//去除集合中，pos对应的数最小的那个
			if (maxPositions.size() == 1) {
				points.remove(maxPositions.iterator().next().intValue());
			} else {
				int min = Integer.MAX_VALUE;
				int minPos = -1;
				for (Integer pos : maxPositions) {
					int point;
					if ((point = points.get(pos)) < min) {
						minPos = pos;
						min = point;
					}
				}
				points.remove(minPos);
			}
		}

		//剩余两个数
		int i1 = points.get(1);
		int i2 = points.get(2);
		sum += i1 * i2;
		if (i1 < i2) {
			sum += i2;
		} else
			sum += i1;
		System.out.println(sum);
	}
}