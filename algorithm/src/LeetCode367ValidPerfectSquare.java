/*
Given a positive integer num, write a function which returns 
True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
*/

public class LeetCode367ValidPerfectSquare {
	// // brute force: O(n) 330ms 9.7%
	// public boolean isPerfectSquare(int num) {
 //        if (num == 1) return true;
        
 //        for (int i = 1; i <= num / 2; i++) {
 //            if (i * i == num) return true;
 //        }
        
 //        return false;
 //    }

	// // O(sqrt(n)) 1ms 28.6%   1 + 3 + 5 + 7 + ... 可以组成平方数
	// public boolean isPerfectSquare(int num) {
	// 	int i = 1;
	// 	while (num > 0) {
	// 		num -= i;
	// 		i += 2;
	// 	}

	// 	return num == 0;
	// }

	// binary search: O(logn) 0ms 100%
	public boolean isPerfectSquare(int num) {
		int left = 0, right = num;
		while (left < right) {
			long mid = left + (right - left) / 2;
			if (mid * mid == num) return true;
			else if (mid * mid < num) left = (int)mid + 1;
			else right = (int)mid;
		}

		return false;
	}
}