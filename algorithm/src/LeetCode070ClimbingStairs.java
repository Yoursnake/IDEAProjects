/*
Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

public class LeetCode070ClimbingStairs {
    public int climbStairs(int n) {
        int[] result;
        if (n == 1) return 1;
        if (n == 2) return 2;

        result = new int[n];
        result[0] = 1;
        result[1] = 2;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n - 1];

    }
}
