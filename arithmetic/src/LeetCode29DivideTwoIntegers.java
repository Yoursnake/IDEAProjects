/*
Example 1:

Input: dividend = 10, divisor = 3
Output: 3

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
 */
public class LeetCode29DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        boolean isCommon = true;
        if ((dividend > 0) ^ (divisor > 0)) isCommon = false;

        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int d = 0;

        while (dvd >= dvs) {
            long temp1 = dvs;
            long temp2 = 1;

            while (dvd >= (temp1 << 1)) {
                temp1 = temp1 << 1;
                temp2 = temp2 << 1;
            }

            dvd -= temp1;
            d += temp2;
        }

        if (!isCommon) d = -d;
        return d;

    }
}
