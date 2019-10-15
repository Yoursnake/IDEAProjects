/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. 
Except for the first two numbers, each subsequent number in the 
sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to 
determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, 
so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 

             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199

Constraints:

num consists only of digits '0'-'9'.
1 <= num.length <= 35

Follow up:
How would you handle overflow for very large input integers?
*/

//import java.math.BigInteger;

public class LeetCode306AdditiveNumber {
	// DFS: 93.11% 1ms
	// 先从开头找 3 个数满足条件，然后调用 DFS 进行递归遍历，排除几种不可能的情况来提升速度
	public boolean isAdditiveNumber(String num) {
		if (num == null || num.length() < 3) return false;

		int len = num.length();

		for (int i = 0; i < len - 2; i++) {
			// 防止第一个数为 0
			if (i >= 1 && num.charAt(0) == '0') break;

			for (int j = i + 1; j < len - 1; j++) {
				// 防止第一个数为 0
				if (j >= i + 2 && num.charAt(i + 1) == '0') break;

				for (int k = j + 1; k < len; k++) {
					// 排除前面两个数和一定小于后一个数的情况
					if (k - j > Math.max(i + 1, j - i) + 1) break;
					// 排除前面两个数和一定大于后一个数的情况
					if (len - 1 - j < Math.max(i + 1, j - i)) break;
					if (k - j < Math.max(i + 1, j - i)) continue;
					// 防止第一个数为 0
					if (k >= j + 2 && num.charAt(j + 1) == '0') break;

					Long num1 = Long.parseLong(num.substring(0, i + 1));
					Long num2 = Long.parseLong(num.substring(i + 1, j + 1));
					Long num3 = Long.parseLong(num.substring(j + 1, k + 1));

					if (num1 + num2 == num3) {
						if (k == len - 1) return true;
						else if (DFS(num, k + 1, num2, num3)) return true;
					}
				}
			}
		}

		return false;
	}

	private boolean DFS(String num, int index, long pre1, long pre2) {
		if (index == num.length()) return true;

		for (int i = index; i < num.length(); i++) {
			// 排除前面两个数和一定小于后一个数的情况
			if (i - index + 1 > Math.max((int)Math.log10(pre1) + 1, (int)Math.log10(pre2) + 1) + 1) break;
			// 排除前面两个数和一定大于后一个数的情况
			if (num.length() - index < Math.max((int)Math.log10(pre1) + 1, (int)Math.log10(pre2) + 1)) break;
			if (i - index + 1 < Math.max((int)Math.log10(pre1) + 1, (int)Math.log10(pre2) + 1)) continue;
			// 防止第一个数为 0
			if (i >= index + 1 && num.charAt(index) == '0') break;

			long curr = Long.parseLong(num.substring(index, i + 1));

			if (pre1 + pre2 == curr && DFS(num, i + 1, pre2, curr)) return true;
		}

		return false;
	}
}