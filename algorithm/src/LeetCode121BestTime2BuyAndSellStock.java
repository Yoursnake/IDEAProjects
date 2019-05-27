/*
Say you have an array for which the ith element is the price of
a given stock on day i.

If you were only permitted to complete at most one transaction
(i.e., buy one and sell one share of the stock), design an algorithm
to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class LeetCode121BestTime2BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int curMax = prices[0];
        int curMin = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - curMin;
            // 如果当前差值大于当前最大收益，则更新收益，
            // 且当前值为当前最大值
            if (temp > result) {
                result = temp;
                curMax = prices[i];
            } else {
                // 如果当前差值小于当前最大收益，且当前值小于当前最小值，
                // 则更新当前最小值
                if (prices[i] < curMin) curMin = prices[i];
            }
        }

        return result;
    }
}
