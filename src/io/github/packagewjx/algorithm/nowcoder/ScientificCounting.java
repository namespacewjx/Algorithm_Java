package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 吴俊贤 on 2017/4/26.
 */
public class ScientificCounting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String num = in.nextLine();
		StringBuilder builder = new StringBuilder();

		//使用正则表达式来匹配和寻找数
		Pattern pattern = Pattern.compile("([+-])([1-9])\\.([0-9]+)E([+-])([0-9]+)");
		Matcher matcher = pattern.matcher(num);
		matcher.find();

		char fuhao = matcher.group(1).charAt(0);//获得符号位
		char zhishuFuhao = matcher.group(4).charAt(0);//获得指数符号
		int zhishu = Integer.parseInt(matcher.group(5));//获得指数
		if (zhishuFuhao == '-')
			zhishu = -zhishu;
		String dishu = matcher.group(2) + matcher.group(3);
		builder.append(dishu);

		if (zhishu > dishu.length()) {
			//末尾补0
			while (builder.length() <= zhishu)
				builder.append(0);
		} else if (zhishu < 0) {
			//前面补小数点和0
			zhishu = -zhishu;
			for (int i = 0; i < zhishu; i++) {
				builder.insert(0, '0');
			}
			builder.insert(1, '.');
		} else {
			if (zhishu < dishu.length() - 1)
				//补回小数点
				builder.insert(zhishu + 1, '.');
		}

		if (fuhao == '-')
			builder.insert(0, '-');


		System.out.println(builder.toString());


	}
}
