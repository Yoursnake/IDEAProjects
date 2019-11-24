/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
*/

import java.util.*;

public class LeetCode345ReverseVowelsofaString {
	// // Stack: O(n) 10ms 15% 两次遍历
	// public String reverseVowels(String s) {
 //        Set<Character> vowels = new HashSet<>();
 //        Stack<Character> stack = new Stack<>();
 //        char[] charArray = s.toCharArray();
        
 //        vowels.add('a');
 //        vowels.add('e');
 //        vowels.add('i');
 //        vowels.add('o');
 //        vowels.add('u');
 //        vowels.add('A');
 //        vowels.add('E');
 //        vowels.add('I');
 //        vowels.add('O');
 //        vowels.add('U');
        
 //        for (int i = 0; i < charArray.length; i++) {
 //            if (vowels.contains(charArray[i])) stack.push(charArray[i]);
 //        }
        
 //        for (int i = 0; i < charArray.length; i++) {
 //            if (vowels.contains(charArray[i])) {
 //                charArray[i] = stack.pop();
 //            }
 //        }
        
 //        return new String(charArray);
 //    }

    // Stack: O(n) 5ms 58% 一次遍历
	public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int i = 0;
        int j = charArray.length - 1;
        
        while (i < j) {
        	while (i < j && !vowels.contains(charArray[i])) i++;
        	while (i < j && !vowels.contains(charArray[j])) j--;

        	if (i >= j) break;

        	char tmp = charArray[i];
        	charArray[i] = charArray[j];
        	charArray[j] = tmp;
        	i++;
        	j++;
        }
        
        return new String(charArray);
    }
}