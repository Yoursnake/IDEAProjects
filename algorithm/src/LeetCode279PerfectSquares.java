/*
Given a positive integer n, find the least number of perfect square 
numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

public class LeetCode279PerfectSquares {
	// // dp: 5.49% 300 ms
	// public int numSquares(int n) {
	// 	int[] dp = new int[n + 1];

	// 	dp[1] = 1;

	// 	for (int i = 2; i < n + 1; i++) {
	// 		if (Math.sqrt(i) == (int)Math.sqrt(i)) {
	// 			dp[i] = 1;
	// 			continue;
	// 		}

	// 		dp[i] = Integer.MAX_VALUE;
	// 		for (int j = 1; j <= i / 2; j++) {
	// 			dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
	// 		}
	// 	}

	// 	return dp[n];
	// }

	// dp improve: 90% 18 ms
	public int numSquares(int n) {
		int[] dp = new int[n + 1];

		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			if (Math.sqrt(i) == (int)Math.sqrt(i)) {
				dp[i] = 1;
				continue;
			}

			dp[i] = Integer.MAX_VALUE;

			for (int j = 1; j <= (int)Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}

		return dp[n];
	}
}