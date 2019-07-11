/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode010RegularExpressionMatching {

    // DP
    public boolean isMatch(String s, String p) {

        String pNew = "";   // 用于存储没有 '*' 的 p
        List<Integer> starPos = new ArrayList<>();  // 用于表示 pNew 中有 '*' 字母的位置
        char[] pChars = p.toCharArray();

        for (int i = 0; i < pChars.length; i++) {
            if (pChars[i] != '*') pNew += pChars[i];
            else starPos.add(pNew.length());
        }

        boolean[][] dp = new boolean[pNew.length() + 1][s.length() + 1];
        dp[0][0] = true;

        // 第一行除了第一个一定都是0，不用遍历
        // 第一列如果从第一个开始连续有 '*' 则赋值到没有 '*' 为止
        for (int i = 1; i < pNew.length() + 1; i++) {
            if (starPos.contains(i)) dp[i][0] = true;
            else break;
        }

        for (int i = 1; i < pNew.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                // 左上角元素如果是 true，则如果当前字符匹配则为 true
                dp[i][j] = dp[i - 1][j - 1] && (s.charAt(j - 1) == pNew.charAt(i - 1) || pNew.charAt(i - 1) == '.');

                // 如果是 '*' 则分两种情况
                // 1. 上方有 true
                // 2. 左方有 true 且 当前字符匹配
                if (starPos.contains(i)) {
                    dp[i][j] |= dp[i - 1][j] ||
                            dp[i][j - 1] && (s.charAt(j - 1) == pNew.charAt(i - 1) || pNew.charAt(i - 1) == '.');
                }
            }
        }

        return dp[pNew.length()][s.length()];
    }

//    // 递归方法，时间复杂度高 （转 DP）
//    public boolean isMatch(String s, String p) {
//        if (p.length() == 1) {  // p 长度为 1 时单独处理，保证 p 长度为 0 或大于 1
//            if (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//
//        if (s.length() == 0 && p.length() == 0) {
//            return true;
//        } else if (s.length() == 0 && p.length() != 0) {
//            // 如果 s 长度为 0，p 长度不为 0，则 p 长度为偶数，且每个元素后面必有一个 '*'
//            if (p.length() % 2 != 0) {
//                return false;
//            } else {
//                for (int i = 1; i < p.length(); i = i + 2) {
//                    if (p.charAt(i) != '*') return false;
//                }
//                return true;
//            }
//        } else if (s.length() != 0 && p.length() == 0) {
//            return false;
//        }
//
//        // 已经排除了 p 长度小于 2 的情况
//        if (p.charAt(1) != '*') {
//            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
//                return isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
//            } else {
//                return false;
//            }
//        } else {
//            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
//                // 分为 '.' 代表元素和不代表元素的情况
//                boolean res1 = isMatch(s.substring(1, s.length()), p);
//                boolean res2 = isMatch(s, p.substring(2, p.length()));
//                return res1 || res2;
//            } else {
//                return isMatch(s, p.substring(2, p.length()));
//            }
//        }
//    }
}
