package io.wicp.namespacewjx.algorithm;

/**
 * Created by 吴俊贤 on 2017/3/3.
 */
public class NumberComplement {
	public static void main(String[] args) {
		System.out.println(new NumberComplement().findComplement(2147483647));
	}

	public int findComplement(int num) {
		if (num == 0) {
			return 1;
		}
		int wei = (int) (Math.log(num) / Math.log(2)) + 1;
		int fan;
		if (wei == 31) {
			fan = 2147483647;
		} else {
			fan = (int) Math.pow(2, wei) - 1;
		}
		return num ^ fan;

	}
}

