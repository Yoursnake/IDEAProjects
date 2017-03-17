/**
 * Created by shengliyi on 2017/3/18.
 */
public class leetcode13RomanToInt {

    public static int romanToInt(String s) {
        int sum = 0;
        int previousPriority = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char tempChar = s.charAt(i);
            int currentPriority = priority(tempChar);
            if (previousPriority <= currentPriority)
                sum += conserveToInt(tempChar);
            else
                sum -= conserveToInt(tempChar);
            previousPriority = currentPriority;
        }
        return sum;
    }

    // 将罗马字符转换为数字
    public static int conserveToInt(char c) {
        switch(c) {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }

    // 判断罗马字符的优先级
    public static int priority(char c) {
        switch(c) {
            case 'I':return 1;
            case 'V':return 2;
            case 'X':return 3;
            case 'L':return 4;
            case 'C':return 5;
            case 'D':return 6;
            case 'M':return 7;
        }
        return 0;
    }
}
