import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		System.out.println(maxK(n, k));
	}


	public static int maxK(int n, int k) {


		for (int i = n / k; i >= 1; i--) {
			if (i <= n - i * k + 1)
				return i;
		}
		return 0;
	}
}