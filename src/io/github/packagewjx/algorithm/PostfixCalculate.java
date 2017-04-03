package io.github.packagewjx.algorithm;

import java.util.Stack;

/**
 * Created by 吴俊贤 on 2017/3/21.
 */
public class PostfixCalculate {
	public static void main(String[] args) {
		System.out.println(calculate("53*21*+"));
	}

	public static int calculate(String postfix) {
		return stackCal(postfix);
	}

	/**
	 * 提供用栈来实现的算法，返回-1则代表字符串有错
	 */
	private static int stackCal(String postfix) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if (c >= '0' && c <= '9') {
				stack.push(c - '0');
			} else if (c >= 'A' && c <= '9') {
				stack.push(c - 'A' + 10);
			} else {
				int result;

				//此时是运算符字符，如果栈里面没有两个元素，
				// 则这个字符串是有问题的，有一个中间结点度为1，不是有效的树
				if (stack.size() < 2)
					return -1;

				//注意，栈顶元素是右子树的结果，因此不能连续pop两次来算，必须先存着
				int a = stack.pop();

				if (c == '+') {
					result = stack.pop() + a;
				} else if (c == '-') {
					result = stack.pop() - a;
				} else if (c == '*') {
					result = stack.pop() * a;
				} else
					return -1;//不是有效的算术符号的时候返回-1
				stack.push(result);
			}
		}

		//若此时栈还有很多个元素，也是有问题的字符串
		if (stack.size() != 1)
			return -1;

		return stack.pop();
	}

	/**
	 * 下面是建树的实现
	 */
	private static int cur = 0;//用来记录当前所指向的字符，用于创建结点的
	private static Node getTree(String tree) {
		if (cur < 0) {
			return null;
		}
		char c = tree.charAt(cur);
		cur--;

		//如果是数字的话，直接返回数字结点就好了
		if (c >= '0' && c <= '9') {
			return new NumNode(c - '0');
		}
		if (c >= 'A' && c <= 'F') {
			return new NumNode(c - 'A' + 10);
		}

		//如果不是数字，则创建运算符结点
		CalNode node;
		switch (c) {
			case '+':
				node = new CalNode(CalNode.ADD);
				break;
			case '-':
				node = new CalNode(CalNode.SUBTRACT);
				break;
			case '*':
				node = new CalNode(CalNode.MULTIPLY);
				break;
			default:
				node = null;
		}

		//递归调用，设置该结点的左右子树。
		node.setRight(getTree(tree));
		node.setLeft(getTree(tree));
		return node;
	}

	public abstract static class Node {
		abstract public int getValue();
	}

	public static class CalNode extends Node {
		public static final int ADD = 1;
		public static final int SUBTRACT = 2;
		public static final int MULTIPLY = 3;
		private int cal;
		private Node left;
		private Node right;

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public CalNode(int cal) {
			this.cal = cal;
		}

		@Override
		public int getValue() {
			switch (cal) {
				case ADD:
					return left.getValue() + right.getValue();
				case SUBTRACT:
					return left.getValue() - right.getValue();
				case MULTIPLY:
					return left.getValue() * right.getValue();
				default:
					return -1;
			}
		}
	}

	public static class NumNode extends Node {
		int value;

		public NumNode(int value) {
			this.value = value;
		}

		@Override
		public int getValue() {
			return value;
		}
	}


}
