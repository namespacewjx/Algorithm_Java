package io.github.packagewjx.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/25.
 */
public class ClassfyNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		int[] nums = new int[count];
		for (int i = 0; i < count; i++) {
			nums[i] = in.nextInt();
		}
		solve(nums);
	}

	public static void solve(int[] nums) {
		int[] result = new int[5];
		boolean a2plus = true;
		int a3count = 0, a1count = 0;
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i] % 5) {
				case 0:
					if (nums[i] % 2 == 0)
						result[0] += nums[i];
					break;
				case 1:
					result[1] += a2plus ? nums[i] : -nums[i];
					a2plus = !a2plus;
					a1count++;
					break;
				case 2:
					result[2]++;
					break;
				case 3:
					a3count++;
					result[3] += nums[i];
					break;
				case 4:
					if (result[4] < nums[i])
						result[4] = nums[i];
					break;
			}
		}
		double a3 = (double) result[3] / a3count;

		//输出结果
		if (result[0] == 0)
			System.out.print("N ");
		else
			System.out.print(result[0] + " ");

		if (a1count == 0)
			System.out.print("N ");
		else
			System.out.print(result[1] + " ");

		if (result[2] == 0)
			System.out.print("N ");
		else
			System.out.print(result[2] + " ");

		if (a3count == 0)
			System.out.print("N ");
		else
			System.out.printf("%.1f ", a3);

		if (result[4] == 0)
			System.out.print("N");
		else
			System.out.print(result[4]);
	}
}
