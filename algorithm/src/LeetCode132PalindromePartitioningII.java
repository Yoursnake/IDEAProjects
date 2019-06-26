/*
Given a string s, partition s such that every substring of the partition is
a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

public class LeetCode132PalindromePartitioningII {
    /*
    DP 26.39%
    如果后n个字符不是回文 dp[n] = min{dp[n-k1], dp[n-k2], ..., dp[n-km]} + 1
    其中 km 表示从 begin 开始前 km 个字符是回文
    如果后n个字符是回文 dp[n] = 0
    */
    public int minCut(String s) {
        int[] dp = new int[s.length()]; // 第 i 个表示字符串后 i+1 个字符组成字符串的最小切数
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = s.length();
        }

        for (int i = 1; i < s.length(); i++) {
            int begin = s.length() - 1 - i;
            for (int j = begin; j < s.length(); j++) {
                if (isPalindrome(s, begin, j)) {
                    // 表明从 begin 开始往后的字符串是回文，则最小切数为 0
                    if (j == s.length() - 1) {
                        dp[i] = 0;
                        continue;
                    }

                    // 表明 begin 到 j 的字符串为回文，切一次，然后加上剩下字符串的最小切数
                    // 剩下字符串长度为 s.length() - 1 - j，由于是数组索引，要再减 1
                    int temp = 1 + dp[s.length() - 2 - j];
                    if (temp < dp[i]) dp[i] = temp;
                }
            }
        }

        return dp[s.length() - 1];
    }

    // 判断是否为回文
    private boolean isPalindrome(String s, int begin, int end) {
        for (int i = begin; i <= (begin + end) / 2; i++) {
            if (s.charAt(i) != s.charAt(end - (i - begin))) return false;
        }
        return true;
    }
}
