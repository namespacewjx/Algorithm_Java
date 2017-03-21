package io.wicp.namespacewjx.algorithm;

/**
 * Created by 吴俊贤 on 2017/3/21.
 */
public class PostfixCalculate {
	public static int calculate(String postfix) {
		return getTree(postfix).getValue();
	}

	public static int cur = 0;//用来记录当前所指向的字符，用于创建结点的
	public static Node getTree(String tree) {
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
