/**
 * Created by shengliyi on 2017/3/16.
 */
public class leetcode9isPalindrome {

    public boolean isPalindrome(int x) {
        int temp = x,count = 0;     // count表示位数
        if (temp == 0) count = 1;   // 如果输入为0，则位数为1
        if (temp < 0) return false; // 如果输入为负数，则返回false
        /*先算出位数*/
        while (temp != 0) {
            temp = temp/10;
            count++;
        }
        int left = count,right = 1; // 用left指向最高位，right指向最低位
        int a,b;                    // a，b用于表示left和right指向位的对应值
        do {
            a = (x/(int)Math.pow(10,left-1))%10;
            b = (x%(int)Math.pow(10,right))/(int)Math.pow(10,right-1);
            if (a != b) break;  // 一旦a和b不相等则结束循环，此时left一定大于right
            left--; right++;
        }while (left > right);
        if (left <= right) return true;
        else return false;
    }
}
