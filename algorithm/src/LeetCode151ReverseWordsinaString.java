/*
Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or
trailing spaces.

Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words
to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your
reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space
 in the reversed string.


Follow up:

For C programmers, try to solve it in-place in O(1) extra space.
 */

public class LeetCode151ReverseWordsinaString {
    public String reverseWords(String s) {
        char[] words = s.trim().toCharArray();
        int len = words.length;
        int ptr = len - 1;

        StringBuilder resSB = new StringBuilder();
        StringBuilder tmpSB = new StringBuilder();
        while (ptr >= 0) {
            char curr = words[ptr];
            if (curr != ' ') {
                tmpSB.insert(0, curr);
            } else {
                // 如果 tmpSb 长度为 0，则不添加到 resSb 中
                if (tmpSB.length() == 0) {
                    ptr--;
                    continue;
                }

                resSB.append(tmpSB);
                resSB.append(' ');
                tmpSB = new StringBuilder();
            }

            ptr--;
        }

        resSB.append(tmpSB);
        return resSB.toString();
    }
}
