import java.math.BigDecimal;

/**
 * Created by shengliyi on 2017/3/29.
 */
public class Chocolate {
    public static void main(String[] args) {
        System.out.println(chocolateNum(50));
    }

    static String chocolateNum(int days) {
//        String num = "1";
        BigDecimal num = BigDecimal.valueOf(1);
        for (int i = days - 1; i >= 1; i--) {
            num = num.add(BigDecimal.valueOf(3));
            num = num.multiply(BigDecimal.valueOf(2));
//            num = multiply2(plus3(num));
        }
        return num.toString();
    }

    static String multiply2(String num) {
        String res = "";
        int length = num.length();
        int temp = 0;
        for (int i = length - 1; i >= 0; i--) {
            int currentNum = num.charAt(i) - '0';
            currentNum = currentNum * 2 + temp;
            temp = currentNum / 10;
            String currentNumString = Integer.toString(currentNum % 10);
            res = currentNumString + res;
        }

        if (temp > 0) {
            res = Integer.toString(temp) + res;
        }

        return res;
    }

    static String plus3(String num) {
        String res = "";
        int length = num.length();
        int temp = 0;
        boolean isFirst = true;

        for (int i = length - 1; i >= 0; i--) {
            int currentNum = num.charAt(i) - '0';
            if (isFirst){
                currentNum = currentNum + 3;
                isFirst = false;
            } else {
                currentNum += temp;
            }
            temp = currentNum / 10;
            String currentNumString = Integer.toString(currentNum % 10);
            res = currentNumString + res;
        }

        if (temp > 0) {
            res = Integer.toString(temp) + res;
        }

        return res;
    }
}
