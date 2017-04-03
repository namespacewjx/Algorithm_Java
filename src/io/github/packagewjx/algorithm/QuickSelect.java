package io.github.packagewjx.algorithm;

public class QuickSelect {
	
	
	
	private static int quick_select(int[] a, int k, int l, int r){
		int result = LomutoPartition(a, l, r);
		if (result == k - 1)
			return a[result];
		else if (result > k - 1)
			return quick_select(a, k, l, result - 1);
		else 
			return quick_select(a, k, result + 1, r);
	}
	
	public static int LomutoPartition(int[] a, int l, int r){
		int p = a[l];
		int s = l;
		
		for (int i = l + 1; i <= r; i++){
			if (a[i] < p){
				s++;
				swap(a, i, s);
			}
		}
		swap(a, l ,s);
		return s;
	}
	
	private static void swap(int[] a, int i1, int i2){
		int temp = a[i1];
		a[i1] = a[i2];
		a[i2] = temp;
	}
	
	private static void displayarray(int[] a){
		for (int i = 0; i < a.length - 1; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println(a[a.length - 1]);
	}
}
