package io.github.packagewjx.algorithm;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/3/23.
 */
public class Netease2017LeihuoGameTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);


		int A1 = 0;
		int A2 = 0;
		int A3 = 0;
		double A4 = 0;
		int A5 = 0;

		boolean isAdd = false;
		int A4Count = 0;
		while (in.hasNextInt()) {
			int n = in.nextInt();
			switch (n % 5) {
				case 0:
					if (n % 2 == 0)
						A1 += n;
					break;
				case 1:
					A2 += isAdd ? n : -1 * n;
					break;
				case 2:
					A3++;
					break;
				case 3:
					A4Count++;
					A4 += n;
					break;
				case 4:
					if (n > A5) {
						A5 = n;
					}
					break;
			}
		}

		A4 /= A4Count;

		System.out.print(A1 == 0 ? "N" : A1);
		System.out.println(" ");
		System.out.print(A2 == 0 ? "N" : A2);
		System.out.println(" ");
		System.out.print(A3 == 0 ? "N" : A3);
		System.out.println(" ");
		System.out.print(A4 == 0 ? "N" : A4);
		System.out.println(" ");
		System.out.print(A5 == 0 ? "N" : A5);
	}


	public static void Problem3(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		in.nextLine();
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			String s = in.nextLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}


	}

	public static class TuiXiangZiSolution {
		public static final char EMPTY = '.';
		public static final char BOX = '*';
		public static final char BLOCK = '#';
		public static final char DEST = '@';
		public static final char PLAYER = 'X';

		public static final int NORTH = 0;
		public static final int SOUTH = 3;
		public static final int EAST = 2;
		public static final int WEST = 1;

		char[][] map;
		int m, n;
		Point boxPoint;
		Point playerPoint;

		class Point {
			int x;
			int y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			@Override
			public boolean equals(Object obj) {
				if (obj instanceof Point) {
					if (((Point) obj).x == x && ((Point) obj).y == y) {
						return true;
					}
				}
				return false;
			}
		}


		public TuiXiangZiSolution(char[][] map) {
			this.map = map;
			m = map.length;
			n = map[0].length;
			playerPoint = find(PLAYER);
			boxPoint = find(BOX);
			//清空箱子和玩家，好计算
			map[playerPoint.x][playerPoint.y] = EMPTY;
			map[boxPoint.x][boxPoint.y] = EMPTY;
		}

		public int solve() {
			//首先把玩家瞬移到箱子隔壁，先知道第一步该往哪里推嘛

			//然后算出到这个最佳点的步数


			return 0;
		}

		public int playerPushAndGo(Point destination, Point boxP, Point playerP, int step, int lastDirection, int[][] stepToGo) {
			//需要返回的情况，Maxvalue表示失败

			if (stepToGo[boxP.x][boxP.y] == 0 || stepToGo[boxP.x][boxP.y] > step) {
				stepToGo[boxP.x][boxP.y] = step;
			} else {
				return Integer.MAX_VALUE;
			}

			//到达终点，并且是最短步数了
			if (boxP.equals(destination)) {
				System.out.println("You have reach the destination! Step is " + step);
				return -1 * step;//把step变成负数，标志成功到达
			}

			//汇报当前的点的位置和上次的方向
			switch (lastDirection) {
				case NORTH:
					System.out.println("Push north success");
					break;
				case SOUTH:
					System.out.println("Push south success");
					break;
				case EAST:
					System.out.println("Push east success");
					break;
				case WEST:
					System.out.println("Push west success");
					break;
			}
			System.out.println("Current Point " + boxP.x + ", " + boxP.y);


			int[] result = new int[4];
			final String[] directionString = {"North", "South", "East", "West"};
			final int[] directions = new int[]{NORTH, SOUTH, EAST, WEST};
			for (int i = 0; i < 4; i++) {
				if (directions[i] != counterDirection(lastDirection)) {
					if (push(boxP, directions[i])) {

					}
				}
			}


			int smallest = Integer.MAX_VALUE;
			int resultSmallest = Integer.MIN_VALUE;
			for (int i = 0; i < result.length; i++) {
				//找到最短路径了，必须返回
				if (result[i] < 0 && resultSmallest < result[i])
					resultSmallest = result[i];
				if (result[i] > 0 && smallest > result[i])
					smallest = result[i];
			}
			return resultSmallest == Integer.MIN_VALUE ? smallest : resultSmallest;

		}


		//最短走过去某个点的算出步数的函数
		public int playerGo(Point destination, Point cur, int step, int direction, int[][] stepToGo) {
			//需要返回的情况，Maxvalue表示失败
			if (cur.x >= m || cur.x < 0 || cur.y >= n || cur.y < 0) {
				return Integer.MAX_VALUE;
			}
			if (map[cur.x][cur.y] != EMPTY && map[cur.x][cur.y] != PLAYER)
				return Integer.MAX_VALUE;

			if (stepToGo[cur.x][cur.y] == 0 || stepToGo[cur.x][cur.y] > step) {
				stepToGo[cur.x][cur.y] = step;
			} else {
				return Integer.MAX_VALUE;
			}

			//到达终点，并且是最短步数了
			if (cur.equals(destination)) {
				System.out.println("You have reach the destination! Step is " + step);
				return -1 * step;//把step变成负数，标志成功到达
			}

			//汇报当前的点的位置和上次的方向
			switch (direction) {
				case NORTH:
					System.out.println("Go north success");
					break;
				case SOUTH:
					System.out.println("Go south success");
					break;
				case EAST:
					System.out.println("Go east success");
					break;
				case WEST:
					System.out.println("Go west success");
					break;
			}
			System.out.println("Current Point " + cur.x + ", " + cur.y);

			//试着走去下一个点
			int[] result = new int[4];
			if (direction != SOUTH) {
				result[0] = playerGo(destination, new Point(cur.x - 1, cur.y), step + 1, NORTH, stepToGo);//go north
				if (result[0] == Integer.MAX_VALUE)
					System.out.println("Go North Failed, Current is " + cur.x + ", " + cur.y);
			}
			if (direction != NORTH) {
				result[1] = playerGo(destination, new Point(cur.x + 1, cur.y), step + 1, SOUTH, stepToGo);//go south
				if (result[1] == Integer.MAX_VALUE)
					System.out.println("Go South Failed, Current is " + cur.x + ", " + cur.y);
			}

			if (direction != WEST) {
				result[2] = playerGo(destination, new Point(cur.x, cur.y + 1), step + 1, EAST, stepToGo);//go east
				if (result[2] == Integer.MAX_VALUE)
					System.out.println("Go West Failed, Current is " + cur.x + ", " + cur.y);
			}
			if (direction != EAST) {
				result[3] = playerGo(destination, new Point(cur.x, cur.y - 1), step + 1, WEST, stepToGo);//go west
				if (result[3] == Integer.MAX_VALUE)
					System.out.println("Go East Failed, Current is " + cur.x + ", " + cur.y);
			}

			int smallest = Integer.MAX_VALUE;
			int resultSmallest = Integer.MIN_VALUE;
			for (int i = 0; i < result.length; i++) {
				//找到最短路径了，必须返回
				if (result[i] < 0 && resultSmallest < result[i])
					resultSmallest = result[i];
				if (result[i] > 0 && smallest > result[i])
					smallest = result[i];
			}

			return resultSmallest == Integer.MIN_VALUE ? smallest : resultSmallest;
		}

		public boolean push(Point boxPoint, int direction) {
			//验证箱子前后两个位置是否为空，一个有玩家，一个是箱子的下一个位置
			Point playerPoint;
			Point nextPoint;
			switch (direction) {
				case NORTH:
					playerPoint = new Point(boxPoint.x + 1, boxPoint.y);
					nextPoint = new Point(boxPoint.x - 1, boxPoint.y);
					break;
				case SOUTH:
					playerPoint = new Point(boxPoint.x - 1, boxPoint.y);
					nextPoint = new Point(boxPoint.x + 1, boxPoint.y);
					break;
				case EAST:
					playerPoint = new Point(boxPoint.x, boxPoint.y - 1);
					nextPoint = new Point(boxPoint.x, boxPoint.y + 1);
					break;
				case WEST:
					playerPoint = new Point(boxPoint.x, boxPoint.y + 1);
					nextPoint = new Point(boxPoint.x, boxPoint.y - 1);
					break;
				default:
					return false;
			}
			if (map[playerPoint.x][playerPoint.y] == EMPTY && map[nextPoint.x][nextPoint.y] == EMPTY)
				return true;
			return false;
		}

		public Point find(char c) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == c) {
						return new Point(i, j);
					}
				}
			}
			return null;
		}

		public static int counterDirection(int direction) {
			return direction ^ 3;
		}

		public static Point getNextPoint(Point cur, int direction) {
			return null;
		}
	}


	public static void Problem2(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int D = in.nextInt();
		int[][] nums = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nums[i][j] = in.nextInt();
			}
		}

		int biggestSum = 0;

		//横的和
		for (int i = 0; i < N; i++) {
			//i表示第几行
			for (int j = 0; j + D <= N; j++) {
				//j表示第几列
				int sum = 0;
				for (int k = 0; k < D; k++) {
					sum += nums[i][j + k];
				}
				if (sum > biggestSum)
					biggestSum = sum;
			}
		}

		//竖的和
		for (int i = 0; i < N; i++) {
			//i表示第几列
			for (int j = 0; j + D <= N; j++) {
				//j表示第几行
				int sum = 0;
				for (int k = 0; k < D; k++) {
					sum += nums[j + k][i];
				}
				if (sum > biggestSum)
					biggestSum = sum;
			}
		}

		//左上到右下的和，i是行，j是列
		for (int i = 0; i + D < N; i++) {
			for (int j = 0; j + D < N; j++) {
				int sum = 0;
				for (int k = 0; k < D; k++) {
					sum += nums[i + k][j + k];
				}
				if (sum > biggestSum)
					biggestSum = sum;
			}
		}

		//右上到左下的和，i是行，j是列
		for (int i = N - 1; i - D >= -1; i--) {
			for (int j = 0; j + D < N; j++) {
				int sum = 0;
				for (int k = 0; k < D; k++) {
					sum += nums[i - k][j + k];
				}
				if (sum > biggestSum)
					biggestSum = sum;
			}
		}

		System.out.println(biggestSum);
	}


	public static void Problem1(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		char c = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			char nc = s.charAt(i);
			if (nc == c) {
				count++;
			} else {
				System.out.print("" + count + c);
				c = nc;
				count = 1;
			}
		}
		System.out.print("" + count + c);
	}
}
