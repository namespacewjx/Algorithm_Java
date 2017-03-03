package io.wicp.namespacewjx.algorithm;

public class MergeSort {
	public static void main(String[] args) {
		int[] a = new int[]{12,878,47,24,69,2585,48,35,1484,24,24,86,58,841,57,369,54,15256,823,8289,8552,554,589,26};
		a = mergesort(a, 0, a.length - 1);
		display(a);
	}
	
	public static void display(int[]a){
		for (int i = 0; i< a.length - 1; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println(a[a.length - 1]);
	}
	
	public static int[] mergesort(int[] a, int l, int r) {
		if (r - l >= 2) {
			int[] a1 = mergesort(a, l, (l + r) / 2);
			int[] a2 = mergesort(a, (l + r) / 2 + 1, r);
			int[] result = merge(a1, a2);
			return result;
		} else {
			if (l == r){
				return new int[]{a[l]};
			}else{
				if (a[l] > a[r]) {
					int temp = a[l];
					a[l] = a[r];
					a[r] = temp;
				}
				return new int[]{a[l], a[r]};
			}
		}
	}

	private static int[] merge(int[] a, int[] b) {
		if (a[0] > b[b.length - 1]) {
			return appendtoend(b, a);
		} else if (b[0] > a[a.length - 1]) {
			return appendtoend(a, b);
		}
		
		int[] result = new int[a.length + b.length];
		int p = 0;
		int q = 0;
		int i = 0;
		while (p < a.length && q < b.length){
			if (a[p] < b[q]){
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
		
		if (p == a.length){
			while (q < b.length){
				result[i] = b[q];
				i++;
				q++;
			}
		} else{
			while (p < a.length){
				result[i] = a[p];
				i++;
				p++;
			}		
		}
		
		return result;
		

	}

	private static int[] appendtoend(int[] front, int[] next) {
		int[] result = new int[front.length + next.length];
		for (int i = 0; i < front.length; i++)
			result[i] = front[i];
		for (int i = 0; i < next.length; i++)
			result[i + front.length] = next[i];
		return result;
	}

}
