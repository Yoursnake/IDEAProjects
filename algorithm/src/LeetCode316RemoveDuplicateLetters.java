/*
Given a string which contains only lowercase letters, remove duplicate 
letters so that every letter appears once and only once. You must make 
sure your result is the smallest in lexicographical order among all 
possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"
*/

import java.util.*;

public class LeetCode316RemoveDuplicateLetters {
	// O(n^2) 1ms 100%
	public String removeDuplicateLetters(String s) {
		boolean[] visited = new boolean[26];	// 表示结果字符串是否包含某字母
		int[] cnt = new int[26];				// 表示结果字符串中还剩的某字母的个数
		StringBuilder sb = new StringBuilder();

		// 统计原字符串每个字母的个数
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			cnt[c - 'a']++;
		}

		// 每次新增字母 c
		// 如果结果字符串已经包含 c，表明前面的 c 不需要删除，当前的 c 不用加入到结果字符串
		// 否则从后往前检查结果字符串，只要字母大于 c，且原字符串后面还存在该字母则删除当前字母，但只要出现一个不符合就立即中断
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!visited[c - 'a']) {
				for (int j = sb.length() - 1; j >= 0; j--) {
					if (sb.charAt(j) > c && cnt[sb.charAt(j) - 'a'] != 0) {
						visited[sb.charAt(j) - 'a'] = false;
						sb.deleteCharAt(j);
					} else {
						break;
					}
				}

				sb.append(c);
				visited[c - 'a'] = true;
			}

			cnt[c - 'a']--;
		}

		return sb.toString();
	}
}