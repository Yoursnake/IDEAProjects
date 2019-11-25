public class LeetCode357CountNumberswithUniqueDigits {
	// dp: O(n) 0ms 100%
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        
        int[] dp = new int[n + 1];	// dp 表示 n 位数一共有多少个 unique number
        dp[1] = 10;
        dp[2] = 81;
        int cnt = 8;
        int res = 91;
        for (int i = 3; i <= n; i++) {
            if (cnt == 0) break;
            dp[i] = dp[i - 1] * cnt;
            res += dp[i];
            cnt--;
        }
        
        return res;
    }
}