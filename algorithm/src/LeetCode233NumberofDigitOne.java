/*
Given an integer n, count the total number of digit 1 appearing 
in all non-negative integers less than or equal to n.

Example:

Input: 13
Output: 6 

Explanation: Digit 1 occurred in the following numbers: 
1, 10, 11, 12, 13.
*/

public class LeetCode233NumberofDigitOne {
	// n = a * 10^t + b
	public int countDigitOne(int n) {
		if (n < 1) return 0;

	    int len = (int)Math.log10(n) + 1;
	    int res = 0;
	    int tmp = 1;

	    for (int i = 0; i < len; i++) {
	    	int a = n / tmp;
	    	int b = n % tmp;

	    	if (a % 10 == 0) res += a / 10 * tmp;
	    	else if (a % 10 == 1) res += a / 10 * tmp + b + 1;
	    	else res += (a / 10 + 1) * tmp;

	    	tmp = tmp * 10;
	    }

	    return res;
	}
}