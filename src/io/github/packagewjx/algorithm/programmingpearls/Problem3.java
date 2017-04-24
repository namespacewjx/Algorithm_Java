package io.github.packagewjx.algorithm.programmingpearls;

/**
 * Created by 吴俊贤 on 2017/4/18.
 * 原题是：实现两个向量旋转的算法，一个是利用一个临时变量储存着0位的字符，然后把后面的字符放过来。一个是先旋转两部分，然后整体旋转。
 */
public class Problem3 {

	public static void main(String[] args) {
		System.out.println(solve1("abcdefgh", 4));
	}

	/**
	 * 使用杂技法。有bug，当length是string长度的因数的时候，会出问题。TODO 这个函数还没有完全实现好
	 * @param string 要旋转的数组
	 * @param length 旋转的长度
	 * @return 旋转后的数组
	 */
	public static String solve1(String string, int length) {
		if (0 == length || string.length() == length) {
			return string;
		}

		char[] chars = string.toCharArray();
		char c0 = chars[0];
		chars[0] = chars[length];
		for (int i = length; i != 0; i = (i + length) % string.length()) {
			chars[i] = chars[(i + length) % string.length()];
		}
		chars[string.length() - length] = c0;
		return new String(chars);
	}

	public static String solve2(String string) {



		return null;
	}
}
