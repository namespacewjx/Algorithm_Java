package io.github.packagewjx.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 吴俊贤 on 2016/10/12.
 */
public class IsomorphicStrings {
	public static void main(String[] args) {
		System.out.println(isPerfectSquare(808201));
	}


	public static boolean isIsomorphic2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Character> chars = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (chars.containsKey(sc)) {
				if (tc == chars.get(sc))
					continue;
				else
					return false;
			} else {
				if (chars.containsValue(tc)) {
					return false;
				} else {
					chars.put(sc, tc);
				}
			}
		}
		return true;
	}

	public static boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		if (num >= Integer.MAX_VALUE)
			return false;
		long up = num;
		long down = 1;
		long n;
		long square;
		while (up > down + 1) {
			n = (up + down) / 2;
			square = n * n;
			if (square == num) {
				return true;
			} else if (square > num) {
				up = n;
			} else if (square < num) {
				down = n;
			}
		}
		return false;
	}
}
