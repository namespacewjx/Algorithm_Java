package io.github.packagewjx.algorithm;

public class Sqrtx {

	public static void main(String[] args) {
		System.out.println(mySqrt(2147483647));
	}

	public static int mySqrt(int x) {
		if (x < 2)
			return x;
		long mid = 0;
		long high = x;
		long low = 1;
		long res = 0;
		
		while (high > low + 1) {
			mid = (high + low) / 2;
			res = mid * mid;
			if (res < x)
				low = (int) mid;
			else if (res > x)
				high = (int) mid;
			if (res == x)
				return (int) mid;
		}
		if (high * high < x)
			return (int) high;
		return (int) low;
	}
}
