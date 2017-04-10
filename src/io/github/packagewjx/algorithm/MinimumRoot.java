package io.github.packagewjx.algorithm;

/**
 * Created by 吴俊贤 on 2017/4/3.
 */
public class MinimumRoot {
	public static void main(String[] args) {
		System.out.println(minimumRoot(7, 14,15));
	}

	public static int minimumRoot(int i1, int i2, int i3) {
		i1 = minimumRoot(i1, i2);
		i2 = minimumRoot(i2, i3);
		return minimumRoot(i1, i2);
	}

	public static int minimumRoot(int i1, int i2) {
		int c1 = log2(i1);
		int c2 = log2(i2);

		if (c1 < c2) {
			int temp = i1;
			i1 = i2;
			i2 = temp;
			temp = c1;
			c1 = c2;
			c2 = temp;
		}

		while (c1 > c2) {
			i1 = getParent(i1);
			c1--;
		}

		while (i1 != i2) {
			i1 = getParent(i1);
			i2 = getParent(i2);
		}

		return i1;
	}

	public static int log2(int i1) {
		return (int) (Math.log(i1) / Math.log(2));
	}

	public static int getParent(int i) {
		return i / 2;
	}

}
