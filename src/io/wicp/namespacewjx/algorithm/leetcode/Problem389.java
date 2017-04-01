package io.wicp.namespacewjx.algorithm.leetcode;

import java.io.UnsupportedEncodingException;

/**
 * Created by 吴俊贤 on 2017/3/31.
 */
public class Problem389 {
	public static void main(String[] args) {
		System.out.println(new Problem389().new Solution2().findTheDifference("acbd", "baced"));
	}

	//利用加法做的，这个可有优化！看Solution3
	public class Solution {
		public char findTheDifference(String s, String t) {
			char sSum = 0;
			for (int i = 0; i < s.length(); i++) {
				sSum += s.charAt(i);
			}

			char tSum = 0;
			for (int i = 0; i < t.length(); i++) {
				tSum += t.charAt(i);
			}

			return (char) (tSum - sSum);
		}
	}

	//利用异或做的
	public class Solution2 {
		public char findTheDifference(String s, String t) {
			byte[] sBytes = s.getBytes();
			byte[] tBytes = t.getBytes();
			int j = 0;
			for (int i = 0; i < sBytes.length; i++) {
				j ^= sBytes[i] ^ tBytes[i];
			}
			j ^= tBytes[tBytes.length - 1];
			return (char) j;
		}
	}

	public class Solution3 {
		public char findTheDifference(String s, String t) {
			int charCode = t.charAt(s.length());
			// Iterate through both strings and char codes
			for (int i = 0; i < s.length(); ++i) {
				charCode -= (int)s.charAt(i);
				charCode += (int)t.charAt(i);
			}
			return (char)charCode;
		}
	}
}
