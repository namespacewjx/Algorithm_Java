package io.github.packagewjx.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	public static void main(String[] args) {
		
		
//		try {
//			FileOutputStream output = new FileOutputStream("result.txt");
//			PrintStream p = new PrintStream(output);
//			System.setOut(p);
			
			ExpressionAddOperators e = new ExpressionAddOperators();
			List<String> result = e.addOperators("000", 0);
			for (String s : result)
				System.out.println(s);
//			p.close();
//			output.close();
//			
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
	}

	public List<String> addOperators(String num, int target) {
		if (Long.parseLong(num) == target){
			suanshis = new ArrayList<>();
			suanshis.add(num);
			return suanshis;
		}
			
		this.target = target;
		this.num = num;
		suanshis = new ArrayList<>();
		int maxloc = num.length() - 1;

		for (int i = 1; i <= maxloc; i++) {
			int[] loc = new int[i];
			for (int j = 0; j < i; j++)
				loc[j] = j + 1;

			do {
				int[] nums = new int[i + 1];
				String valstring = num.substring(0, loc[0]);
				if (!isValidString(valstring))
					continue;
				nums[0] = Integer.parseInt(valstring);
				int j;
				for (j = 1; j < i; j++){
					valstring = num.substring(loc[j - 1], loc[j]);
					if (!isValidString(valstring))
						break;
					nums[j] = Integer.parseInt(valstring);
				}
				if (j != i)
					continue;
				valstring = num.substring(loc[i - 1]);
				if (!isValidString(valstring))
					continue;
				nums[i] = Integer.parseInt(valstring);
				cal(0, nums, 0, Jia, "");
			} while (nextrcomb(loc, i, maxloc));
		}
		return suanshis;
	}

	private int target;
	private String num;
	private ArrayList<String> suanshis;
	private static final int Jia = 0;
	private static final int Jian = 1;
	private static final int Cheng = 2;

	public void cal(long result, int[] num, int index, int operator, String suanshi) {
		switch (operator) {
		case Jia:
			suanshi = index == 0 ? "" + num[index] : suanshi + "+" + num[index] ;

			if (index + 1 < num.length)
				cal(result, num, index + 1, Cheng, num[index], suanshi);

			result += num[index];

			break;
		case Jian:
			suanshi += "-" + num[index];

			if (index + 1 < num.length)
				cal(result, num, index + 1, Cheng,  -1 * num[index], suanshi);

			result -= num[index];

			break;
		default:
			return;
		}
		index++;
		if (index == num.length) {
			System.out.println(suanshi + "=" + result);
			if (result == target)
				suanshis.add(suanshi);
			return;
		}

		cal(result, num, index, Jia, suanshi);
		cal(result, num, index, Jian, suanshi);

	}

	public void cal(long jiaresult, int[] num, int index, int operator, long chengshu, String suanshi) {
		if (operator != Cheng)
			return;
		chengshu *= num[index];
		suanshi += "*" + num[index];

		index++;

		if (index == num.length) {
			System.out.println(suanshi + "=" + (jiaresult + chengshu));
			if (jiaresult + chengshu == target)
				suanshis.add(suanshi);
			return;
		}

		cal(jiaresult + chengshu, num, index, Jia, suanshi);
		cal(jiaresult + chengshu, num, index, Jian, suanshi);
		cal(jiaresult, num, index, Cheng, chengshu, suanshi);

	}

	public boolean isValidString(String s){
		return s.matches("[1-9][0-9]*") || s.equals("0");
	}
	
	public boolean nextrcomb(int[] comb, int r, int n) {
		for (int i = comb.length - 1; i >= 0; i--) {
			if (comb[i] != (n - r + i + 1)) {
				comb[i]++;
				for (int j = i + 1; j < r; j++) {
					comb[j] = comb[i] + j - i;
				}
				return true;
			}
		}
		return false;
	}

}
