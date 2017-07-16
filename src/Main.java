import java.util.*;

public class Main {
public static void main(String[] args) {

}
}

class pr2 {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] array = new int[n * 3];
	for (int i = 0; i < n * 3; i++) {
		array[i] = in.nextInt();
	}
	Arrays.sort(array);
	long sum = 0;
	for (int i = n * 3 - 2; i >= n; i -= 2) {
		sum += array[i];
	}

	System.out.println(sum);
}
}


class pr1 {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] array = new int[n];
	for (int i = 0; i < n; i++) {
		array[i] = in.nextInt();
	}

	System.out.println(sortedSubArray(array));
}


public static int sortedSubArray(int[] array) {
	if (array.length <= 1)
		return array.length;

	int count = 1;
	boolean isAscend = false;
	boolean lastEqaul = true;
	for (int i = 0; i < array.length - 1; i++) {
		if (array[i] == array[i + 1]) {
			lastEqaul = true;
			continue;
		}

		if (lastEqaul) {
			isAscend = array[i] < array[i + 1];
			lastEqaul = false;
			continue;
		}

		if (isAscend != array[i] < array[i + 1]) {
			count++;
			lastEqaul = true;
		}
	}
	return count;
}
}


