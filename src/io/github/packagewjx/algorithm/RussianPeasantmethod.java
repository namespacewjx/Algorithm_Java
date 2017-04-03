package io.github.packagewjx.algorithm;

public class RussianPeasantmethod {
	public static void main(String[] args) {
		long num1 = 323141213L;
		long num2 = 312848546L;
		
		long start = System.nanoTime();
		System.out.println(multi(num1,num2));
		long time1 = System.nanoTime();
		System.out.println(num1 * num2);
		long time2 = System.nanoTime();
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time1 - start);
		System.out.println(time2 - time1);
	}
	
	public static long multi(long n1, long n2){
		//let the smaller one to be the one divided by 2
		if (n1 > n2){
			long temp = n1;
			n1 = n2;
			n2 = temp;
		}
		
		long addnum = 0; 
		
		while (n1 > 1){
			if (n1 % 2 == 1){
				addnum += n2;
			}
			n2 *= 2;
			n1 /= 2;
		}
		addnum += n2;
		return addnum;
	}
}
