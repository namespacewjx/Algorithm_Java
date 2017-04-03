package io.github.packagewjx.algorithm;

public class SortingAlgorithm {

	public static void main(String[] args) {
		int num = 100000;
		int max = 1000;
		int[] a = new int[num];
		System.out.println("Before Sorting");
		for (int i = 0; i < num; i++) {
			a[i] = (int) (Math.random() * max);
			System.out.println(a[i]);
		}
		System.out.println("Start Sorting");
		long start = System.nanoTime();
		
//		a = MergeSort(a, 0, a.length - 1);
//		SelectionSort(a);
		a = DistributeSortNoMax(a);
		
		start = System.nanoTime() - start;
		double ms = (double) start / 1000000;
		System.out.println("After Sorting");
		for (int i = 0; i < num; i++) {
			System.out.println(a[i]);
		}
		System.out.println("End Sorting, time is " + ms + "ms");
	}

	public static void SelectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[smallest])
					smallest = j;
			}
			swap(a, i, smallest);
		}
	}

	
	public static int[] MergeSort(int[] a, int l, int r) {
		if (l - r == 1) {
			if (a[l] > a[r])
				return new int[] { a[l], a[r] };
			else
				return new int[] { a[r], a[l] };
		} else if (l == r)
			return new int[] { a[l] };
		else {
			int[] a1 = MergeSort(a, l, (l + r) / 2);
			int[] a2 = MergeSort(a, (l + r) / 2 + 1, r);
			return merge(a1, a2);
		}
	}

	private static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		if (a[a.length - 1] < b[0]) {
			for (int i = 0; i < a.length; i++)
				result[i] = a[i];
			for (int i = 0; i < b.length; i++)
				result[i + a.length] = b[i];
			return result;
		}

		if (b[b.length - 1] < a[0]) {
			for (int i = 0; i < b.length; i++)
				result[i] = b[i];
			for (int i = 0; i < a.length; i++)
				result[i + b.length] = a[i];
			return result;
		}

		int p, q;
		p = q = 0;
		int i = 0;
		while (p < a.length && q < b.length) {
			if (a[p] < b[q]) {
				result[i] = a[p];
				i++;
				p++;
			}
			else{
				result[i] = b[q];
				i++;
				q++;
			}
		}
		while (p < a.length){
			result[i] = a[p];
			i++;
			p++;
		}
		while (q < b.length){
			result[i] = b[q];
			i++;
			q++;
		}
		return result;
	}

	
	public static void swap(int[] a, int m, int n) {
		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
	}

	public static int[] DistributeSortNoMax(int[] a){
		int max = 0;
		for (int i = 1; i < a.length; i++){
			if (a[i] > a[max])
				max = i;
		}
		return DistributeSort(a, a[max]);
	}
	
	
	public static int[] DistributeSort(int[] a, int max){
		int[] count = new int[max + 1];
		for (int i = 0; i < a.length; i++)
			count[a[i]]++;
		
		count[0] -= 1;
		for (int i = 1; i < count.length; i++)
			count[i] = count[i - 1] + count[i];
		
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++){
			result[count[a[i]]] = a[i];
			count[a[i]]--;
		}
		return result;
	}
	
}
