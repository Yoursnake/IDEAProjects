/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
where the two words do not share common letters. You may assume that each word will 
contain only lower case letters. If no such two words exist, return 0.

Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16 
Explanation: The two words can be "abcw", "xtfn".

Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4 
Explanation: The two words can be "ab", "cd".

Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0 
Explanation: No such pair of words.
*/

public class LeetCode318MaximumProductofWordLengths {
	// // brute force1: 28% 62ms 	用数组表示 map
	// public int maxProduct(String[] words) {
 //        int max = 0;
        
 //        for (int i = 0; i < words.length; i++) {
 //            boolean[] map = new boolean[26];
 //            for (char c : words[i].toCharArray()) {
 //                map[c - 'a'] = true;
 //            }
            
 //            loop:
 //            for (int j = i + 1; j < words.length; j++) {
 //                for (char c : words[j].toCharArray()) {
 //                    if (map[c - 'a'] == true) continue loop;
 //                }
                
 //                if (max < words[i].length() * words[j].length()) 
 //                    max = words[i].length() * words[j].length();
 //            }
 //        }
        
 //        return max;
 //    }

    // brute force2: 65% 5ms   用整型表示 map （26 bit）
	public int maxProduct(String[] words) {
        int max = 0;

        int[] maps = new int[words.length];
        
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                maps[i] = maps[i] | (1 << (c - 'a'));
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((maps[i] & maps[j]) == 0)     // 两个 map 的与操作等于 0 表示两个字符串没有相同元素
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        
        return max;
    }
}