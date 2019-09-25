/*
Given two strings s and t , write a function to determine 
if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would 
you adapt your solution to such case?
*/

import java.util.Map;
import java.util.HashMap;

public class LeetCode242ValidAnagram {
	// // HashMap: 16.93% 21ms
	// public boolean isAnagram(String s, String t) {
	// 	if (s.length() != t.length()) return false;

	// 	Map<Character, Integer> map = new HashMap<>();

	// 	for (char c : s.toCharArray()) {
	// 		if (!map.containsKey(c)) map.put(c, 1);
	// 		else map.put(c, map.get(c) + 1);
	// 	}

	// 	for (char c : t.toCharArray()) {
	// 		if (!map.containsKey(c) || map.get(c) == 0) return false;
	// 		else map.put(c, map.get(c) - 1);
	// 	}

	// 	return true;
	// }

	// Array: 78.19% 4ms
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;

		int[] map = new int[26];

		for (char c : s.toCharArray()) {
			map[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			if (map[c - 'a'] == 0) return false;
			else map[c - 'a']--;
		}

		return true;
	}

	// // sort: 64.71% 5ms
	// public boolean isAnagram(String s, String t) {
	// 	if (s.length() != t.length()) return false;

	// 	char[] sChars = s.toCharArray();
	// 	char[] tChars = t.toCharArray();

	// 	Arrays.sort(sChars);
	// 	Arrays.sort(tChars);

	// 	return String.valueOf(sChars).equals(String.valueOf(tChars));
	// }
}