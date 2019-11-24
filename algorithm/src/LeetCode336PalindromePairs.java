/*
Given a list of unique words, find all pairs of distinct indices (i, j) 
in the given list, so that the concatenation of the two words, i.e. 
words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
*/

import java.util.*;

public class LeetCode336PalindromePairs {
	// // brute force: TLE
	// public List<List<Integer>> palindromePairs(String[] words) {
	// 	List<List<Integer>> res = new ArrayList<>();
	// 	for (int i = 0; i < words.length; i++) {
	// 		for (int j = 0; j < words.length; j++) {
	// 			if (j == i) continue;

	// 			if (judgePalindrome(words[i] + words[j])) {
	// 				List<Integer> tmp = new ArrayList<>(Arrays.asList(i, j));
	// 				res.add(tmp);
	// 			}
	// 		}
	// 	}

	// 	return res;
	// }

	// private boolean judgePalindrome(String word) {
	// 	for (int i = 0; i < word.length() / 2; i++) {
	// 		if (word.charAt(i) != word.charAt(word.length() - 1 - i)) return false;
	// 	}

	// 	return true;
	// }

	// HashMap: 75ms 32.5%
	public List<List<Integer>> palindromePairs(String[] words) {
		if (words == null || words.length <= 1) return Collections.EMPTY_LIST;

		List<List<Integer>> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) map.put(words[i], i);

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);

				if (judgePalindrome(str1)) {
					String str2rev = new StringBuilder(str2).reverse().toString();
					if (map.containsKey(str2rev) && map.get(str2rev) != i) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(map.get(str2rev));
						tmp.add(i);
						res.add(tmp);
					}
				}

				if (judgePalindrome(str2)) {
					String str1rev = new StringBuilder(str1).reverse().toString();
					// 注意这里有个 str2.length() != 0 避免产生重复
					if (map.containsKey(str1rev) && map.get(str1rev) != i && str2.length() != 0) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(i);
						tmp.add(map.get(str1rev));
						res.add(tmp);
					}
				}
			}
		}

		return res;
	}

	private boolean judgePalindrome(String word) {
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) return false;
		}
		return true;
	}
}