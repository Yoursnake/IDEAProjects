/*
Given a string s, you are allowed to convert it to a
palindrome by adding characters in front of it. Find
and return the shortest palindrome you can find by
performing this transformation.

Example 1:

Input: "aacecaaa"
Output: "aaacecaaa"

Example 2:

Input: "abcd"
Output: "dcbabcd"
 */

public class LeetCode214ShortestPalindrome {

//    // 暴力枚举：35%
//    public String shortestPalindrome(String s) {
//        char[] chars = s.toCharArray();
//        StringBuilder sb = new StringBuilder(s);
//
//        int maxPalinIndex;
//        for (maxPalinIndex = chars.length - 1; maxPalinIndex >= 0; maxPalinIndex--) {
//            if (judgePalindrome(chars, 0, maxPalinIndex)) break;
//        }
//
//        for (int i = maxPalinIndex + 1; i < chars.length; i++) {
//            sb.insert(0, chars[i]);
//        }
//
//        return sb.toString();
//    }
//
//    private boolean judgePalindrome(char[] chars, int left, int right) {
//        while (left < right) {
//            if (chars[left] != chars[right]) return false;
//            left++;
//            right--;
//        }
//
//        return true;
//    }

    // kmp: 54%
    public String shortestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder(s);
        String doubleStr = sb.append(new StringBuilder(s).reverse().toString()).toString();

        char[] chars = doubleStr.toCharArray();
        int[] kmp = new int[chars.length];
        kmp[0] = 0;
        int j = 0, i = 1;
        while(i < chars.length) {
            if (chars[i] == chars[j]) {
                kmp[i++] = j + 1;
                j++;
            } else {
                if (j != 0) j = kmp[j - 1];
                else kmp[i++] = 0;
            }
        }

        int k = kmp[kmp.length - 1];
        while (k > s.length()) {
            k = kmp[k - 1];
        }

        for (; k < s.length(); k++)
            res.insert(0, s.charAt(k));

        return res.toString();
    }
}
