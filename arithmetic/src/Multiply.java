/**
 * Created by shengliyi on 2017/3/28.
 */
public class Multiply {

    public static String multiply(String num1, String num2) {
        String res = "";
        num1 = removeZero(num1);    // 先去除 num1, num2 首部的零
        num2 = removeZero(num2);

        // 将 num1 换成位数较大的数
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int length1 = num1.length(), length2 = num2.length();

        // 在 num2 开头补零使之与 num1 长度相等
        for (int i = 0; i < length1 - length2; i++) {
            num2 = "0" + num2;
        }

        // 如果长度小等于 2 则直接用乘法运算
        if (num1.length() <= 2) {
            return Integer.toString(Integer.parseInt(num1) * Integer.parseInt(num2));
        } else {
            // 通过 num 长度中点分割 num1，num2
            int middle = num1.length() / 2;
            String num1Pre = num1.substring(0, middle);
            String num1Next = num1.substring(middle, num1.length());
            String num2Pre = num2.substring(0, middle);
            String num2Next = num2.substring(middle, num2.length());

            // 第一部分为 num1Pre 和 num2Pre 的积，使用递归
            String part1 = multiply(num1Pre, num2Pre);
            // 第二部分为 num1Pre * num2Next + num2Pre * num1Next
            String part2 = plus(multiply(num1Pre, num2Next), multiply(num2Pre, num1Next));
            // 第三部分为 num1Next * num2Next
            String part3 = multiply(num1Next, num2Next);

            // 在 part2 和 part3 前面补零，使之长度为 num1.length() - middle + 1(能够进位的长度)
            for (int i = part2.length(); i <= num1.length() - middle; i++)
                part2 = "0" + part2;
            for (int i = part3.length(); i <= num1.length() - middle; i++)
                part3 = "0" + part3;

            // 保留 part3 和 part2 最后 num1.length() - middle 位值，将前面剩下的作为进位值
            String over1 = part3.substring(0, part3.length() - (num1.length() - middle));
            part3 = part3.substring(part3.length() - (num1.length() - middle), part3.length());
            part2 = plus(part2, over1);

            String over2 = part2.substring(0, part2.length() - (num1.length() - middle));
            part2 = part2.substring(part2.length() - (num1.length() - middle), part2.length());
            part1 = plus(part1, over2);
            // 出去 part1 前面的零
            part1 = removeZero(part1);

            res = part1 + part2 + part3;
        }

        return res;
    }

    public static String plus(String num1, String num2) {
        String res = "";
        int tempNum = 0;

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int length1 = num1.length(), length2 = num2.length();

        for (int i = 0; i < length1 - length2; i++) {
            num2 = "0" + num2;
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(i) - '0';
            int sum = n1 + n2 + tempNum;
            tempNum = sum / 10;
            res = Integer.toString(sum % 10) + res;
        }

        if (tempNum != 0) {
            res = "1" + res;
        }

        return res;
    }

    public static String removeZero(String num) {
        int i = 0;
        String res;
        while (num.charAt(i) == '0' && i != num.length() - 1)
            i++;
        res = num.substring(i, num.length());
        return res;
    }
}
