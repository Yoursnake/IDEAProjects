/**
 * Created by shengliyi on 2017/3/17.
 */
public class LeetCode012intToRoman {
    public static String intToRoman(int num) {
        int count = 0; // 表示 num 的位数
        int temp = num;
        String romanNumber = "";
        while (temp != 0) {
            temp = temp/10;
            count++;
        }
        while (count != 0) {    // count 表示当前位数
            int firstDigit = (int)(num/Math.pow(10,count-1)%10);
            switch (count) {
                case 1:
                    romanNumber += conversion(firstDigit, 'I', 'V', 'X');break;
                case 2:
                    romanNumber += conversion(firstDigit, 'X', 'L', 'C');break;
                case 3:
                    romanNumber += conversion(firstDigit, 'C', 'D', 'M');break;
                case 4:
                    romanNumber += conversion(firstDigit, 'M', ' ', ' ');break;
            }
            count--;
        }
        return romanNumber;
    }

    // 输入当前位罗马数字 1 和 5 的表示即可得到当前位的罗马数字
    public static String conversion(int firstDigit, char c1, char c5, char c10) {
        String romanNumber = "";
        if (firstDigit >= 0 && firstDigit <= 3)
            for (int i = 0; i < firstDigit; i++)
                romanNumber += c1;
        else if (firstDigit == 4)
            romanNumber += ("" + c1 + c5);
        else if (firstDigit >= 5 && firstDigit <= 8){
            romanNumber +=  c5;
            for (int i = 0; i < firstDigit - 5; i++)
                romanNumber += c1;
        }
        else if (firstDigit == 9)
            romanNumber += ("" + c1 + c10);

        return romanNumber;
    }
}
