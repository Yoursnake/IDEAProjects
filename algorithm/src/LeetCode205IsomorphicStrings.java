/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same
character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true

Note:
You may assume both s and t have the same length.
 */

import java.util.HashMap;

public class LeetCode205IsomorphicStrings {
    // map 70.02%
    // String 转成 char[] 可提升性能
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char sCurr = sChars[i];
            char tCurr = tChars[i];

            // 如果 map 中存在 key 且这个 key 和要存的 val 不同：不同构
            // 如果 map 中不存在 key 但要存的 val 已存在 map 中：不同构
            if (map.containsKey(sCurr)) {
                if (map.get(sCurr) != tCurr) return false;
            } else {
                if (map.containsValue(tCurr)) return false;
                else map.put(sCurr, tCurr);
            }
        }

        return true;
    }
}
