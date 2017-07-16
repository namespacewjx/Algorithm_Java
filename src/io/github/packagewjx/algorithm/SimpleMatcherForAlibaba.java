package io.github.packagewjx.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/26.
 */
public class SimpleMatcherForAlibaba {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String pattern = in.nextLine();

		System.out.println(match(line, pattern) ? "1" : "0");
	}

	public static boolean match(String str, String pattern) {
		//空pattern会有bug
		if (pattern.length() == 0)
			return false;

		char[] chars = str.toCharArray();
		char[] pat = pattern.toCharArray();
		int cur = 0;
		boolean flag = true;//标记匹配成功与否
		for (int i = 0; i < pat.length; i++) {
			switch (pat[i]) {
				case '*':
					cur++;//至少匹配一个字符，因此先加加
					while (cur < chars.length) {
						if (i + 1 < pat.length) {
							//若pattern的下一个字符与当前字符相同，则进去
							//BUG所在地！
							if (pat[i + 1] == chars[cur]) {
								//查看pattern中与chars中相同字母开头的子串，是否匹配，若匹配，则直接返回true，若否，则用*匹配此字符
								char[] sub1 = Arrays.copyOfRange(chars, cur, chars.length);
								char[] pat2 = Arrays.copyOfRange(pat, i + 1, pat.length);
								if (match(new String(sub1), new String(pat2)))
									return true;
							}
						}
						cur++;
					}
					break;
				case '?'://只匹配一个字符，直接加加
					cur++;
					break;
				default:
					//若pattern当前字符与输入字符相同，则继续匹配，若不是，则匹配失败
					if (chars[cur] == pat[i])
						cur++;
					else
						flag = false;
			}

			//全部字符串用完之后，pattern还有字符串，因此匹配失败
			if (cur == chars.length && i != pat.length - 1)
				flag = false;

			if (!flag)
				break;
		}
		return flag;
	}
}
