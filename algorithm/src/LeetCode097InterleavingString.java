/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
 */

public class LeetCode097InterleavingString {
//    // 递归做法（超时）
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length() + s2.length() != s3.length()) return false;
//
//        if (s1.length() == 0) {
//            return s2.equals(s3);
//        }
//
//        if (s2.length() == 0) {
//            return s1.equals(s3);
//        }
//
//        boolean res1 = false;
//        boolean res2 = false;
//        if (s1.charAt(0) == s3.charAt(0)) {
//            res1 = isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length()));
//        }
//
//        if (s2.charAt(0) == s3.charAt(0)) {
//            res2 = isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()));
//        }
//
//        if (!res1 && !res2) {
//            return false;
//        } else {
//            return true;
//        }
//    }

    // dp
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        int s1Len = s1.length();
        int s2Len = s2.length();
        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        dp[0][0] = true;

        // 对第一行进行赋值，如果左边元素是true，且s2当前元素和s3一致，则为当前元素true
        for (int j = 1; j < s2Len + 1; j++) {
            if (dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)) dp[0][j] = true;
            else break;
        }

        // 对第一列进行赋值，同上
        for (int i = 1; i < s1Len + 1; i++) {
            if (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0] = true;
            else break;
        }

        for (int i = 1; i < s1Len + 1; i++) {
            for (int j = 1; j < s2Len + 1; j++) {
                if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
                        || dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s1Len][s2Len];
    }
}
