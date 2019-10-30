/*
You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that 
amount. If that amount of money cannot be made up by any combination of the coins, 
return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.
*/

import java.util.*;

public class LeetCode322CoinChange {
	// // DFS: TLE
	// public int coinChange(int[] coins, int amount) {
 //        return coinChange(coins, coins.length - 1, amount, Integer.MAX_VALUE);
 //    }
    
 //    private int coinChange(int[] coins, int index, int amount) {
 //        if (index == 0) {
 //            if (amount % coins[0] == 0) return amount / coins[0];
 //            else return -1;
 //        }
        
 //        int minNum = Integer.MAX_VALUE;
 //        for (int i = 0; i <= amount / coins[index]; i++) {
 //            int nextNum = coinChange(coins, index - 1, amount - coins[index] * i);
 //            if (nextNum != -1) minNum = Math.min(minNum, i + nextNum);
 //        }
        
 //        if (minNum == Integer.MAX_VALUE) return -1;
 //        else return minNum;
 //    }

	// DP: 46% 15ms   dp[i] = min(dp[i], dp[i-coins[j]]+1), for j=0,1,2,...,coins.length-1
	// dp 表示每一个面值的最少硬币数
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		Arrays.fill(dp, Integer.MAX_VALUE - 1);		// 这里使用 Integer.MAX_VALUE - 1，不然后面会越界
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0)
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}

		if (dp[amount] == Integer.MAX_VALUE - 1) return -1;
		else return dp[amount];
	}
}