/*
Given a string, determine if it is a palindrome, considering only alphanumeric
characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */

public class LeetCode125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;

        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        do {
            while (leftIndex < s.length() && !isAlphaNumber(s.charAt(leftIndex))) leftIndex++;
            while (rightIndex >= 0 && !isAlphaNumber(s.charAt(rightIndex))) rightIndex--;
            if (leftIndex == s.length() && rightIndex == -1) return true;   // 字符串中无数字字母字符的情况

            char leftChar = s.charAt(leftIndex);
            char rightChar = s.charAt(rightIndex);
            if (leftChar == rightChar) {
                // 相等情况可以通过
            } else if (isAlpha(leftChar) && isAlpha(rightChar)
                    && Math.abs(leftChar - rightChar) == 'a' - 'A') {
                // 如果不等，那在两个都是字母的情况下，且是大小写关系可以通过
            } else {    // 否则不能通过
                return false;
            }
            leftIndex++;
            rightIndex--;
        } while (leftIndex < rightIndex);

        return true;
    }

    // 判断是否为数字字母字符
    private boolean isAlphaNumber(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') return true;
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    // 判断是否是字母字符
    private boolean isAlpha(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') return true;
        return false;
    }
}
