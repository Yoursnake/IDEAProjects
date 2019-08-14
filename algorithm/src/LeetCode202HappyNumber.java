/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the
sum of the squares of its digits, and repeat the process until
the number equals 1 (where it will stay), or it loops endlessly
in a cycle which does not include 1. Those numbers for which this
process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

 */

import java.util.HashSet;
import java.util.Set;

public class LeetCode202HappyNumber {
    public boolean isHappy(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        Set<Integer> set = new HashSet<>();

        while (true) {
            int sum = 0;
            while (n != 0) {
                int curr = n % 10;
                sum += curr * curr;
                n = n / 10;
            }

            // 如果 set 中包含这个数证明会无线循环，break 出去返回 false
            if (set.contains(sum)) break;
            else set.add(sum);

            if (sum == 1) return true;
            else n = sum;   // 更新 n 为 sum
        }

        return false;
    }
}
