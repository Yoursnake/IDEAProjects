/*
Given a non-empty string s and a dictionary wordDict containing a list of
non-empty words, determine if s can be segmented into a space-separated
sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the
segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as
"apple pen apple".

Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

import java.util.List;

public class LeetCode139WordBreak {
    // DP   f[n] = f[m] && wordDict.contains(s.substring(m, n))  0 <= m < n
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] check = new boolean[s.length() + 1];  // 第 i 个表示前 i 个字符串是否能用 wordDict 表示
        check[0] = true;

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (check[i]) break;
                check[i] = check[j] && wordDict.contains(s.substring(j, i));
            }
        }

        return check[s.length()];
    }

}
