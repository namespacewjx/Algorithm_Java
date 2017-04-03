package io.github.packagewjx.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/3/13.
 */
public class Tester {
	public static void main(String[] args) throws IOException {
		Scanner din = new Scanner(System.in);
		int count = Integer.parseInt(din.nextLine());
		LinkedList<String> words = new LinkedList<String>();
		while (count > 0) {
			words.add(din.nextLine());
			count--;
		}

	}

	public int xunhuan(LinkedList<String> words) {
		int result = 0;
		for (int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			for (int j = 0; j < word.length(); j++) {
				String xunword = word.substring(word.length() - j, word.length()) + word.substring(0, word.length() - j);
				for (int k = i + 1; k < words.size(); k++) {
					if (xunword.equals(words.get(k))) {
						result++;
						words.remove(k);
						k = k - 1;
					}
				}
			}
		}
		return 1;
	}


	private static void testStreamMark() throws IOException {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
		bufferedInputStream.mark(100);
		byte[] s = new byte[10];
		bufferedInputStream.read(s);
		System.out.println(s);
		bufferedInputStream.reset();
		bufferedInputStream.read(s);
		System.out.println(s);
	}
	public int getSplitNode(String[] matrix, int indexA, int indexB) {
		if (indexA == indexB)
			return indexA;
		if (matrix.length == 1) {
			return 0;
		}
		return -1 * traverse(matrix, indexA, indexB, 0, 0);
	}

	public int traverse(String[] matrix, int indexA, int indexB, int cur, int last){
		int count = 0;
		if (cur == indexA || cur == indexB){
			count += 1;
		}
		for (int i = 0; i < matrix.length; i++){
			if (matrix[cur].charAt(i) == '1' && i != last){
				int tra = traverse(matrix, indexA, indexB, i, cur);
				if (tra < 0)
					return tra;
				else
					count += tra;
			}
		}
		if (count == 2){
			return -1 * cur;
		}
		else return count;
	}

}
