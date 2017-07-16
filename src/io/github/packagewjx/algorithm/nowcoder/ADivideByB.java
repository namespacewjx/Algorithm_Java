package io.github.packagewjx.algorithm.nowcoder;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/25.
 * https://www.nowcoder.com/pat/6/problem/4043
 */
public class ADivideByB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(divide(s.substring(0, s.length() - 2), s.charAt(s.length() - 1) - '0'));
	}

	public static String divide(String A, int B) {
		int count = 0;//计算已经算了多少个数
		int mod = 0;//部分余数
		int num = 0;//部分除数
		int result = 0;
		StringBuilder shang = new StringBuilder(A.length() - 1);
		for (; A.length() - count >= 8; count += 8) {
			num = mod * 100000000 + Integer.valueOf(A.substring(count, count + 8));
			result = num / B;
			String format = String.format("%08d", result);
			shang.append(format);
			mod = num % B;
		}
		//处理剩下的
		if (count != A.length()) {
			num = (int) (Integer.valueOf(A.substring(count, A.length())) + mod * Math.pow(10, A.length() - count));
			result = num / B;
			String format = String.format("%0" + (A.length() - count) + "d", result);
			shang.append(format);
			shang.append(' ').append(num % B);
		}
		//去掉开头的0
		if (shang.charAt(0) == '0')
			shang.deleteCharAt(0);
		return shang.toString();
	}
}
