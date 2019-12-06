/*
Your task is to calculate ab mod 1337 where a is a positive integer 
and b is an extremely large positive integer given in the form of an array.

Example 1:

Input: a = 2, b = [3]
Output: 8
Example 2:

Input: a = 2, b = [1,0]
Output: 1024
*/

public class LeetCode372SuperPow {
	// 6ms 39%  a * b % k = (a % k) * (b % k) % k
	// 参考：https://leetcode.com/problems/super-pow/discuss/84472/C%2B%2B-Clean-and-Short-Solution
	public int superPow(int a, int[] b) {
		return superPow(a, b, b.length - 1);
	}

	private int superPow(int a, int[] b, int end) {
		if (end < 0) return 1;
		return powMod(superPow(a, b, end - 1), 10) * powMod(a, b[end]) % base;
	}

	// return a^k%1337
	private int powMod(int a, int k) {
		int base = 1337;
		int res = 0;
		a %= base;

		for (int i = 0; i < k; i++) {
			res = (res * a) % base;
		}

		return res;
	}
}