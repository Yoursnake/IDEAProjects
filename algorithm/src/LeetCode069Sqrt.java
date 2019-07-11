/*
Example 1:

Input: 4
Output: 2

Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */

public class LeetCode069Sqrt {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        long low = 0;
        long high = x / 2 + 1;

        // 二分法
        while (true) {
            long mid = (low + high) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) return (int)mid;
            else if ((mid + 1) * (mid + 1) <= x) low = mid + 1;
            else if (mid * mid > x) high = mid - 1;
        }
    }
}
