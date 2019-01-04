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

public class LeetCode258AddDigits {

    public static int addDigits(int num) {
        if (num/10 == 0) return num;    //如果num是个位数则返回num
        int newNum = 0;
        while (num != 0) {
            int temp = num%10;
            newNum += temp;
            num = num/10;
        }
        return addDigits(newNum);     //使用递归

    }

    public static int addDigits2(int num) {
        while (num/10 != 0) {
            num = num%9;
            if (num == 0) {
                num = 9;
            }
        }
        return num;
    }

// (x + y) % z = (x % z + y % z) % z，
// 又因为 x % z % z = x % z，因此结果为 (num - 1) % 9 + 1
    public static int addDigits3(int num) {
        return (num-1)%9 + 1;
    }
}
