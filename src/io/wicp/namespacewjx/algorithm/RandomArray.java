package io.wicp.namespacewjx.algorithm;

import java.util.Random;

public class RandomArray {
	public static void main(String[] args) {
		int num = 13;
		int[] a = randomarray(num);
		for (int i = 0; i < num; i++)
			System.out.println(a[i]);
	}
	
	public static int[] randomarray(int n){
		int[] result = new int[n];
		for (int i = 0; i < n; i++)
			result[i] = i + 1;
		int temp = 0;
		for (int i = 0; i < n; i++){
			temp = (int) (Math.random() * (n - i));
			swap(result, n - 1 - i, temp);
		}
		return result;
	}
	
	private static void swap(int[] a, int i1, int i2){
		int temp = a[i1];
		a[i1] = a[i2];
		a[i2] = temp;
	}
	
}
