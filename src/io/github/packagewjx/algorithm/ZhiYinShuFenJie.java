package io.github.packagewjx.algorithm;

public class ZhiYinShuFenJie {
	public static void main(String[] args) {
		System.out.println(fenjie(1088));
	}
	
	public static String fenjie(int num){
		int curChu = 2;
		String result = String.valueOf(num) + "=";
		while (num > 1){
			if (num % curChu != 0){
				curChu = nextZhiShu(curChu);
			}
			else{
				num /= curChu;
				result += String.valueOf(curChu) + 'x';
			}
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}
	
	private static int nextZhiShu(int curZhiShu){
		while (true){
			curZhiShu++;
			boolean isZhiShu = true;
			for (int i = 2; i < curZhiShu / 2; i++){
				if (curZhiShu % i == 0){
					isZhiShu = false;
					break;
				}
			}
			if (isZhiShu)
				return curZhiShu;
		}
	}
}
