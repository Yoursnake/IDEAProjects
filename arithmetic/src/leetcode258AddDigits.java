/**
 * Created by shengliyi on 2017/3/12.
 */

/*
Given a non-negative integer num, repeatedly add all its digits until the result
 has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
Since 2 has only one digit, return it.
*/

public class leetcode258AddDigits {

    public static int addDigits(int num) {
        if (num/10 == 0) return num;    //如果num是个位数则返回num
        int newNum = 0;
        while (num != 0) {
            int temp = num%10;
            newNum += temp;
            num = num/10;
        }
        return addDigits(newNum);
    }
}
