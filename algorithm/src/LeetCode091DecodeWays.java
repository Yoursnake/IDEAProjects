/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

public class LeetCode091DecodeWays {
    public int numDecodings(String s) {

        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()];
        if (s.charAt(s.length() - 1) == '0') dp[0] = 0;
        else dp[0] = 1;

        if (s.length() == 1) return dp[0];      // 如果只有一位数直接 return

        if (s.charAt(s.length() - 2) == '0') {
            dp[1] = dp[0];
        } else {    // 如果前一位不是 0 ，则这个两位数字一定大于等于 10
            // 倒数两位的数字
            int num = (s.charAt(s.length() - 2) - '0') * 10 + s.charAt(s.length() - 1) - '0';
            if (num == 10 || num == 20) {
                dp[1] = 1;
            } else if (num >= 11 && num <= 26) {
                dp[1] = 2;
            } else {
                if (num % 10 == 0) return 0;    // 表示 n = 30,40,...,90的情况，直接无法解码
                else dp[1] = 1;                 // 如果 n > 26，请不能被10整除，则只能分解成两个数字来解码
            }
        }

        for (int i = 2; i < s.length(); i++) {
            int index = s.length() - i - 1;     // 表示当前
            int num1 = s.charAt(index) - '0';
            int num2 = (s.charAt(index) - '0') * 10 + s.charAt(index + 1) - '0';
            if (num2 == 0) return 0;    // 表示两位都是 0，无法解码

            if (num1 == 0) {
                dp[i] = dp[i - 1];
            } else {
                if (num2 == 10 || num2 == 20) {
                    dp[i] = dp[i - 2];
                } else if (num2 >= 11 && num2 <= 26) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    if (num2 % 10 == 0) return 0;   // 同上
                    else dp[i] = dp[i-1];
                }
            }
        }

        return dp[dp.length - 1];
    }

}
