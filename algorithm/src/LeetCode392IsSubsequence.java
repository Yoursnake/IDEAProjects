/*
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. 
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original 
string by deleting some (can be none) of the characters without disturbing 
the relative positions of the remaining characters. (ie, "ace" is a subsequence 
of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want 
to check one by one to see if T has its subsequence. In this scenario, how would 
you change your code?
*/

import java.util.*;

public class LeetCode392IsSubsequence {
	// // Greddy: O(m+n) 14ms 64%
	// public boolean isSubsequence(String s, String t) {
 //        int p1 = 0, p2 = 0;
        
 //        while (p1 < s.length() && p2 < t.length()) {
 //            if (t.charAt(p2) == s.charAt(p1)) p1++;
 //            p2++;
 //        }
        
 //        return p1 == s.length();
 //    }

	// List + BinarySearch: O(nlogm) 27ms 15.8%   followup
	public boolean isSubsequence(String s, String t) {
		List<Integer>[] idx = new List[26];	// 表示 26 个字符在 t 中的索引

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (idx[c - 'a'] == null) idx[c - 'a'] = new ArrayList<>();
			idx[c - 'a'].add(i);
		}

		int prev = 0;	// 上一个找到的位置 + 1
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (idx[c - 'a'] == null) return false;
			int j = Collections.binarySearch(idx[c - 'a'], prev);
			if (j < 0) j = -j - 1;
			if (j == idx[c - 'a'].size()) return false;
			prev = idx[c - 'a'].get(j) + 1;
		}

		return true;
	}
}