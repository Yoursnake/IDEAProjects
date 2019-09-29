/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between 
a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Notes:
You may assume pattern contains only lowercase letters, and str contains 
lowercase letters that may be separated by a single space.
*/

import java.util.*;

public class LeetCode290WordPattern {
	// // HashMap: O(n) 99% 1ms
	// public boolean wordPattern(String pattern, String str) {
	// 	String[] words = str.split(" ");
	// 	char[] p = pattern.toCharArray();

	// 	if (words.length != p.length) return false;

	// 	Map<String, String> map = new HashMap<>();

	// 	for (int i = 0; i < p.length; i++) {
	// 		String s1 = p[i] + "0"; // 后面加个 0 用来区分 key 和 value
	// 		String s2 = words[i];

	// 		if (map.containsKey(s1)) {
	// 			if (!map.get(s1).equals(s2)) return false;
	// 		} else if (map.containsKey(s2)) {
	// 			if (!map.get(s2).equals(s1.substring(0, s1.length() - 1))) return false;
	// 		} else {
	// 			map.put(s1, s2);
	// 			map.put(s2, s1);
	// 		}
	// 	}

	// 	return true;
	// }

	// HashMap + HashSet: O(n) 99% 1ms
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		char[] p = pattern.toCharArray();

		if (words.length != p.length) return false;

		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < p.length; i++) {
			char c = p[i];
			String s = words[i];

			if (map.containsKey(c)) {
				if (!map.get(c).equals(s)) return false;
			} else {
				if (set.contains(s)) return false;

				set.add(s);
				map.put(c, s);
			}
		}

		return true;
	}
}