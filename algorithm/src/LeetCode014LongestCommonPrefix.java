/*
Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

public class LeetCode14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int minLen = strs[0].length();
        int numStrs = strs.length;
        String commonPrefix = "";

        for (int i = 1; i < strs.length; i++) {
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }

        for (int i = 0; i < minLen; i++) {
            boolean isCommon = true;

            char c = strs[0].charAt(i);
            for (int j = 1; j < numStrs; j++) {
                if (strs[j].charAt(i) != c) {
                    isCommon = false;
                    break;
                }
            }

            if (isCommon) {
                commonPrefix += c;
            } else {
                break;
            }
        }

        return commonPrefix;
    }
}
