package io.wicp.namespacewjx.algorithm;

public class HoarePatition {
	public interface FindPivot{
		public int find(int[] a, int l, int r);
	}
	
	private class RandomPivot implements FindPivot{
		public RandomPivot(){}
		public int find(int[] a, int l, int r){
			return (int) (Math.random() * (r - l + 1));
		}
	}
	
	private class ThreeNumPivot implements FindPivot{
		public ThreeNumPivot(){}
		public int find(int[] array, int l, int r){
			int a = array[l];
			int b = array[r];
			int c = array[(l + r) / 2];
			if (a < b){
				if(c < a){
					return l;
				}else{
					if (b < c)
						return r;
					else
						return (l + r) / 2;
				}
			}else{
				if (c > a){
					return l;
				}else{
					if (b < c)
						return (l + r) / 2;
					else
						return r;
				}
			}
		}
	}
//
//	public static int partition(int[] a, int l, int r){
//		FindPivot fp = new RandomPivot();
//		int i = l;
//		int j = r;
//		int p = fp.find(a, l, r);
//		while (i < j){
//			while (a[i] <= a[p])
//				i++;
//			while (a[l] >= a[p])
//				j++;
//			swap(a, i, j);
//		}
//		swap(a, i, j);
//		swap(a, i, l);
//		return i;
//
//	}
	
	private static void swap(int[] a, int i1, int i2){
		int temp = a[i1];
		a[i1] = a[i2];
		a[i2] = temp;
	}

}
