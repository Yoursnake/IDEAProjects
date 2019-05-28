/*
Say you have an array for which the ith element is the price
of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete
at most two transactions.

Note: You may not engage in multiple transactions at the same time
(i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3),
profit = 3-0 = 3. Then buy on day 7 (price = 1) and sell on day 8
(price = 4), profit = 4-1 = 3.

Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5),
profit = 5-1 = 4. Note that you cannot buy on day 1, buy on day 2
and sell them later, as you are engaging multiple transactions at
the same time. You must sell before buying again.

Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class LeetCode123BestTime2BuyAndSellStockIII {
    /*
    分成左半部分和右半部分，然后每次算左半部分和右半部分的和的最大值
    方法一：计算和使用 LeetCode 121 的算法，时间复杂度O(N^2) 空间复杂度 O(1)
     */
//    public int maxProfit(int[] prices) {
//        if (prices.length == 0 || prices.length == 1) return 0;
//
//        int result = 0;
//        for (int i = 0; i <= prices.length; i++) {
//            int temp = maxProfit(prices, 0, i) + maxProfit(prices, i, prices.length);
//            if (temp > result) result = temp;
//        }
//
//        return result;
//    }
//
//    private int maxProfit(int[] prices, int begin, int end) {
//        int len = end - begin;
//        if (len == 0 || len == 1) return 0;
//
//        int curMin = prices[begin];
//        int result = 0;
//        for (int i = begin + 1; i < end; i++) {
//            int temp = prices[i] - curMin;
//            // 如果当前差值大于当前最大收益，则更新收益，
//            // 且当前值为当前最大值
//            if (temp > result) {
//                result = temp;
//            } else {
//                // 如果当前差值小于当前最大收益，且当前值小于当前最小值，
//                // 则更新当前最小值
//                if (prices[i] < curMin) curMin = prices[i];
//            }
//        }
//
//        return result;
//    }

    /*
    方法二：使用动态规划保存所有左边和右边部分的一步的最大值
    时间复杂度 O(N) 空间复杂度 O(N)
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) return 0;

        int[] leftProfits = new int[len];
        int[] rightProfits = new int[len];

        // 计算从左到右的一次最大收益
        leftProfits[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            leftProfits[i] = Math.max(leftProfits[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        // 计算从右到左的一次最大收益
        rightProfits[len - 1] = 0;
        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightProfits[i] = Math.max(rightProfits[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            int temp = leftProfits[i] + rightProfits[i];
            if (temp > result) result = temp;
        }

        return result;
    }

}
