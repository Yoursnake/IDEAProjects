/*
Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true

Example 2:

Input: 0
Output: false

Example 3:

Input: 9
Output: true

Example 4:

Input: 45
Output: false

Follow up:
Could you do it without using any loop / recursion?
*/

public class LeetCode326PowerofThree {
	// // loops: O(n) 11ms 80.5%
	// public boolean isPowerOfThree(int n) {
 //        if (n <= 0) return false;
        
 //        while (n != 1) {
 //            if (n % 3 == 0) n = n / 3;
 //            else return false;
 //        }
        
 //        return true;
 //    }

	// 11ms 80.5%
	public boolean isPowerOfThree(int n) {
		// 这里要用 log10，不然会有精度问题   （243 会报错）
		double ans = Math.log10(n) / Math.log10(3);
		return ans == (int)ans;
	}
}