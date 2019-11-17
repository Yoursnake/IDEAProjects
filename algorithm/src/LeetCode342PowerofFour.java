/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?
*/

public class LeetCode342PowerofFour {
	// 1ms 100%
	public boolean isPowerOfFour(int num) {
		// 0x55555555 二进制为 0101 0101 0101 0101 0101 0101 0101 0101 和 num 与就是找奇数位上为 1 的数
		return (num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0);
	}
}