package io.github.packagewjx.algorithm;

public class CalLowest1 {
	public static void main(String[] args) {
		System.out.println(callowest1(1233));
	}
	
	public static int callowest1(int num){
		int result = 0;
		while (num % 2 == 0){
			result++;
			num /= 2;
		}
		return result + 1;
		
	}
}
