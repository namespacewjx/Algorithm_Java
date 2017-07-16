package io.github.packagewjx.algorithm.nowcoder;

import java.util.*;

public class Main {

	public static void main(String[] args) {

//		ArrayList<Integer> inputs = new ArrayList<Integer>();
//		Scanner in = new Scanner(System.in);
//		String line = in.nextLine();
//		if(line != null && !line.isEmpty()) {
//			int res = resolve(line.trim());
//			System.out.println(String.valueOf(res));
//		}
		System.out.println(resolve("11 1 + 2 ^ *"));
	}

	// write your code here
	public static int resolve(String expr) {
		char[] exp = expr.toCharArray();
		Stack<Integer> nums = new Stack<>();
		for (int i = 0; i < exp.length; i++) {
			char c = exp[i];
			if (c >= '0' && c <= '9') {
				int num = c - '0';
				if (nums.size() == 16)
					return -2;
				while ((c = exp[++i]) != ' ')
					num = num * 10 + c - '0';
				nums.push(num);
				continue;
			}
			int a, b;
			try {
				switch (c) {
					case '+':
						a = nums.pop();
						b = nums.pop();
						nums.push(a + b);
						break;
					case '*':
						a = nums.pop();
						b = nums.pop();
						nums.push(a * b);
						break;
					case '^':
						nums.push(nums.pop() + 1);
				}
			} catch (EmptyStackException e) {
				return -1;
			}
		}
		return nums.pop();
	}
}