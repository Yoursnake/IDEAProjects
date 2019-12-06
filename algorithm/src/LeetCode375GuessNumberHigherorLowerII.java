/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. 
You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
*/

public class LeetCode375GuessNumberHigherorLowerII {
	// // DP iterative: O(n^3) 8ms 21%   dp[i][j] = min(i<=k<=j){k + max{dp[i][k - 1], dp[k + 1][j]}}
	// // 参考：https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84787/Java-DP-solution
	// public int getMoneyAmount(int n) {
	// 	int[][] dp = new int[n + 1][n + 1];		// 表示范围 i 到 j 至少要花多少钱

	// 	for (int dis = 1; dis <= n - 1; dis++) {
	// 		for (int i = 1; i + dis <= n; i++) {
	// 			int j = i + dis;
	// 			dp[i][j] = Integer.MAX_VALUE;
	// 			for (int k = i; k <= j; k++) {
	// 				dp[i][j] = Math.min(dp[i][j], k + 
	// 					Math.max(k - 1 >= i ? dp[i][k - 1] : 0, 
	// 						k + 1 <= j ? dp[k + 1][j] : 0));
	// 			}
	// 		}
	// 	}

	// 	return dp[1][n];
	// }

	// DP recursive: O(n^3) 7ms 42%
	// 参考：https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 1][n + 1];
		return getRangeMoneyAmount(dp, 1, n);
	}

	// 获取范围 i 到 j 要花多少钱
	private int getRangeMoneyAmount(int[][] dp, int i, int j) {
		if (i >= j) return 0;
		if (dp[i][j] != 0) return dp[i][j];

		int res = Integer.MAX_VALUE;

		for (int k = i; k <= j; k++) {
			int tmp = k + Math.max(getRangeMoneyAmount(dp, i, k - 1), getRangeMoneyAmount(dp, k + 1, j));
			res = Math.min(res, tmp);
		}

		dp[i][j] = res;

		return res;
	}
}