    public class Main {
        public static String[] numChar = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        public static String[] weiChar = new String[]{"", "拾", "佰", "仟"};
        public static String[] suffixChar = new String[]{"", "万", "亿"};

        public static void main(String[] args) {
            solve(151121.15);
        }

        public static String solve(double number) {
            StringBuilder builder = new StringBuilder();


            int zheng = (int) number;
//            double frac = Math.r(number - zheng);
//            //小数部分
//            if (frac != 0) {
//                int digit = (int) (frac * 10);
//                while (digit > 0) {
//                    builder.append(numChar[digit]);
//                    frac = frac * 10 - digit;
//                    digit = (int) (frac * 10);
//                }
//            } else {
//                builder.append("整");
//            }
            //整数部分
            if (zheng == 0)
                builder.insert(0, "零元");
            else {
                int weishu = (int) (Math.log(zheng) / Math.log(10) + 1);
                int[] digits = new int[10];
                int index = 0;
                while (zheng > 0) {
                    int high = (int) (zheng / Math.pow(10, weishu - 1));
                    zheng = (int) (zheng % Math.pow(10, weishu -1));
                    digits[index] = high;
                    index++;
                    weishu--;
                }
                int suffixIndex = 0;
                int weiIndex = 0;
                int count = 0;
                for (index--; index >= 0; index--) {
                    if (count % 4 == 0)
                        builder.insert(0, suffixChar[count / 4]);
                    builder.insert(0, weiChar[count % 4]);
                    builder.insert(0, numChar[digits[index]]);
                    count++;
                }
            }
            return builder.toString();
        }
    }