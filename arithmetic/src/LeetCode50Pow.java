/*
Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */

public class LeetCode50Pow {
    public double myPow(double x, int n) {
        double result = x;
        if (n == 0) {
            if (x == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (n == Integer.MIN_VALUE) {
                n = n + 2;  // 如果 n 是 -2147483648 则只有符号会决定结果，所以加二。
            }

            // 二分法
            int a = Math.abs(n);
            double temp = myPow(x, a / 2);
            if (a % 2 == 0) {
                result = temp * temp;
            } else {
                result *= temp * temp;
            }
        }

        return (n < 0) ? 1 / result : result;

    }
}
