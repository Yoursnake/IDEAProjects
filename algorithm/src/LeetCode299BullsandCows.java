/*
You are playing the following Bulls and Cows game with your friend: 
You write down a number and ask your friend to guess what the number is. 
Each time your friend makes a guess, you provide a hint that indicates 
how many digits in said guess match your secret number exactly in both 
digit and position (called "bulls") and how many digits match the secret 
number but locate in the wrong position (called "cows"). Your friend will 
use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and 
friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

Note: You may assume that the secret number and your friend's guess only 
contain digits, and their lengths are always equal.
*/

import java.util.*;

public class LeetCode299BullsandCows {
	// // HashMap: 22.54% 6ms
	// public String getHint(String secret, String guess) {
	// 	Map<Character, Integer> map = new HashMap<>();
	// 	int bullNum = 0;
	// 	int cowNum = 0;
	// 	int len = guess.length();

	// 	for (char c : secret.toCharArray()) {
	// 		if (!map.containsKey(c)) map.put(c, 1);
	// 		else map.put(c, map.get(c) + 1);
	// 	}

	// 	for (int i = 0; i < len; i++) {
	// 		char c = guess.charAt(i);

	// 		if (secret.charAt(i) == guess.charAt(i)) {
	// 			bullNum++;

	// 			if (!map.containsKey(c)) cowNum--;
	// 			else if (map.get(c) == 1) map.remove(c);
	// 			else map.put(c, map.get(c) - 1);
	// 		} else if (map.containsKey(c)) {
	// 			cowNum++;

	// 			if (map.get(c) == 1) map.remove(c);
	// 			else map.put(c, map.get(c) - 1);
	// 		}
	// 	}

	// 	return bullNum + "A" + cowNum + "B";
	// }

	// Array: 100% 1ms
	public String getHint(String secret, String guess) {
		int[] map = new int[10];
		int bullNum = 0;
		int cowNum = 0;
		int len = guess.length();

		// 用数组表示 secret 中每个数字出现的次数
		for (char c : secret.toCharArray()) map[c - '0']++;

		for (int i = 0; i < len; i++) {
			char c = guess.charAt(i);

			if (secret.charAt(i) == guess.charAt(i)) {
				// 如果对应位置相同，则 bullNum 必加 1
				bullNum++;

				if (map[c - '0'] == 0) cowNum--;	// 如果该位的 map 此时为 0，表明之前被 cow 用掉了 1，把 cow 中的减去
				else map[c - '0']--;				// 否则直接减 1，表示该位用了 1 次
			} else if (map[c - '0'] != 0) {
				// 如果对应位置不同，且该位的数字存在 map 中，则 cowNum 加 1（可能会和后面的 bull 冲突）
				cowNum++;

				map[c - '0']--;
			}
		}

		return bullNum + "A" + cowNum + "B";
	}
}