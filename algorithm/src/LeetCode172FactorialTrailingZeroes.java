/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
 */

public class LeetCode172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;

        // 每次迭代表示一个 5^i
        while (n > 0) {
            result += n / 5;
            n /= 5;
        }

        return result;
    }
}
