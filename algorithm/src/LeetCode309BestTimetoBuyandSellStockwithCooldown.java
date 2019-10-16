/*
Say you have an array for which the ith element is the price of a given 
stock on day i.

Design an algorithm to find the maximum profit. You may complete as many 
transactions as you like (ie, buy one and sell one share of the stock 
multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you 
must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

import java.util.*;

public class LeetCode309BestTimetoBuyandSellStockwithCooldown {
	// // DP1: O(n^2) 8% 15ms   dp[i] = Math.max(dp[i - 1], p[i] - p[j] + dp[j-2](2<= j <= i-1), p[i] - p[1], p[i] - p[0])
	// public int maxProfit(int[] prices) {
	// 	if (prices == null || prices.length <= 1) return 0;
	// 	if (prices.length == 2) return Math.max(prices[1] - prices[0], 0);
	// 	if (prices.length == 3) return Math.max(Math.max(Math.max(prices[1] - prices[0], prices[2] - prices[0]), prices[2] - prices[1]), 0);

	// 	int[] dp = new int[prices.length];

	// 	dp[0] = 0;
	// 	dp[1] = Math.max(prices[1] - prices[0], 0);
	// 	dp[2] = Math.max(Math.max(Math.max(prices[1] - prices[0], prices[2] - prices[0]), prices[2] - prices[1]), 0);

	// 	for (int i = 3; i < prices.length; i++) {
	// 		dp[i] = dp[i - 1];

	// 		for (int j = i - 1; j >= 0; j--) {
	// 			if (j >= 2) dp[i] = Math.max(prices[i] - prices[j] + dp[j - 2], dp[i]);
 //                else dp[i] = Math.max(prices[i] - prices[j], dp[i]);
	// 		}
	// 	}

	// 	return dp[prices.length - 1];
	// }


	// // DFS: O(2^n) TLE
	// public int maxProfit(int[] prices) {
	// 	if (prices == null || prices.length == 0) return 0;

	// 	Queue<Integer> res = new LinkedList<>();
	// 	res.offer(0);
	// 	DFS(prices, 0, 0, res, -1);

	// 	return res.poll();
	// }

	// private void DFS(int[] prices, int index, int curr, Queue<Integer> res, int lastPrice) {
	// 	if (index >= prices.length) {
	// 		int max = Math.max(res.poll(), curr);
	// 		res.offer(max);
	// 		return;
	// 	}

	// 	for (int i = index; i < prices.length; i++) {
	// 		if (lastPrice < 0) {
	// 			DFS(prices, i + 1, curr, res, prices[i]);
	// 		} else {
	// 			if (prices[i] > lastPrice) DFS(prices, i + 2, curr + prices[i] - lastPrice, res, -1);
	// 		}
	// 	}
	// }

	// DP: 82% 1ms
	// １. 在第i天买一支股票还能剩下的利润＝第(i-2)天销售能够剩余的利润－第i天股票的价钱
	// ２. 在第i天卖一支股票总的利润＝第(i-1)天买股票剩下的最大利润＋当前股票的价格 
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;

		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];

		buy[0] = -prices[0];
		buy[1] = Math.max(-prices[0], -prices[1]);
		sell[0] = 0;
		sell[1] = Math.max(prices[1] - prices[0], 0);

		for (int i = 2; i < prices.length; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}

		return sell[prices.length - 1];
	}
}