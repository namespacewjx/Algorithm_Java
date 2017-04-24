import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		ArrayList<Integer> integers = new ArrayList<>();

		while (in.hasNextInt()) {
			int i = in.nextInt();
			if (i == 0)
				break;
			integers.add(i);
		}

		int[] tree = buildTree(integers);

		System.out.println(getAllPathSum(tree));

	}

	public static int getAllPathSum(int[] tree) {
		return traverse(tree, 0, 0);
	}

	public static int traverse(int[] tree, int cur, int sum) {
		if (tree[cur] == 0)
			return sum;
		sum += tree[cur];
		return traverse(tree, leftChild(cur), sum) + traverse(tree, rightChild(cur), sum);
	}



	public static int[] buildTree(ArrayList<Integer> integers) {
		int[] tree = new int[15];

		for (Integer integer : integers) {
			int ceng = integer / 100;
			int ji = integer % 100 / 10;
			int num = integer % 10;
			tree[(int) Math.pow(2, ceng - 1) + ji - 1] = num;
		}

		return tree;
	}

	public static int getParent(int index) {
		return index == 0 ? 0 : (index - 1) / 2;
	}

	public static int leftChild(int index) {
		return index * 2 + 1;
	}

	public static int rightChild(int index) {
		return index * 2 + 2;
	}




}