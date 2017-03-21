package io.wicp.namespacewjx.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 吴俊贤 on 2017/3/12.
 */
public class RegularExpressionTest {
	public static void main(String[] args) {
		//试用捕获组
		Pattern pattern = Pattern.compile("(\\d+\\+?)");
		Matcher matcher = pattern.matcher("1+2+3");
		while (matcher.find()) {
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group(1));
		}
	}
}
