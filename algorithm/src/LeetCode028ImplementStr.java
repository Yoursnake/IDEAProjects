/*
Return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1


 */

public class LeetCode028ImplementStr {


    // 暴力穷举2
    public int strStr(String haystack, String needle) {
        int lenHaystack = haystack.length();
        int lenNeedle = needle.length();

        if (lenNeedle == 0) {
            return 0;
        }

        int i = 0, j = 0;
        while (i < lenHaystack && j < lenNeedle) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == lenNeedle) {
            return i - j;
        } else {
            return -1;
        }
    }

//    // 暴力穷举
//    public int strStr(String haystack, String needle) {
//        if (needle.equals("")) {
//            return 0;
//        }
//
//        if (haystack.equals("")) {
//            return -1;
//        }
//
//        char[] haystackChars = haystack.toCharArray();
//        char[] needleChars = needle.toCharArray();
//
//        for (int i = 0; i < haystackChars.length; i++) {
//            if (haystackChars[i] == needleChars[0]) {
//                if (needleChars.length == 1) {
//                    return i;
//                }
//
//                boolean isNeedle = false;
//                for (int j = 1; j < needleChars.length && i + j < haystackChars.length; j++) {
//                    if (haystackChars[i + j] != needleChars[j]) {
//                        break;
//                    }
//
//                    if (j == needleChars.length - 1) {
//                        isNeedle = true;
//                    }
//                }
//
//                if (isNeedle) {
//                    return i;
//                }
//            }
//        }
//
//        return -1;
//    }
}
