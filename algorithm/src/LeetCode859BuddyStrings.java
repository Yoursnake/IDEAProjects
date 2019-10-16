/*
Given two strings A and B of lowercase letters, return true if and only 
if we can swap two letters in A so that the result equals B.

Example 1:

Input: A = "ab", B = "ba"
Output: true

Example 2:

Input: A = "ab", B = "ab"
Output: false

Example 3:

Input: A = "aa", B = "aa"
Output: true

Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:

Input: A = "", B = "aa"
Output: false

Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.
*/

// O(n): 70% 2ms
public class LeetCode859BuddyStrings {
	public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        
        int[] idx = new int[2];		// 表示不同字母所在的索引
        int[] c = new int[26];		// 表示出现字母的次数
        int count = 0;
        int diffNum = 0;
        boolean repeat = false;		// 判断字符串中是否有重复
        
        for (int i = 0; i < A.length(); i++) {
            if (++c[A.charAt(i) - 'a'] >= 2) repeat = true;
            
            if (A.charAt(i) != B.charAt(i)) {
                diffNum++;
                if (diffNum > 2) return false;                
                idx[count++] = i;
            }
        }
        
        if (diffNum == 0 && repeat) return true;	// 如果 A B 一致，且其中有重复则返回 true
        
        // 如果 A B 有两个不同位置且 A B 中的对应位置相同则返回 true
        return (diffNum == 2 && A.charAt(idx[0]) == B.charAt(idx[1]) && A.charAt(idx[1]) == B.charAt(idx[0]));
    }
}