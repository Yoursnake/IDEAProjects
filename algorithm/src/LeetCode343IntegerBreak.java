/*
Given a positive integer n, break it into the sum of at least two positive 
integers and maximize the product of those integers. Return the maximum 
product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

Note: You may assume that n is not less than 2 and not larger than 58.
*/

public class LeetCode343IntegerBreak {
	// 0ms 100%
	// 优先分解成 3，剩下的分解成 2
	// 为什么要分解成 2 和 3，参考：https://leetcode.com/problems/integer-break/discuss/80721/Why-factor-2-or-3-The-math-behind-this-problem.
	public int integerBreak(int n) {
		// 2 和 3 单独考虑
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        int twoNum = 0;
        int threeNum = 0;
        
        while (n > 2) {
            if (n == 4) break;
            
            n = n - 3;
            threeNum++;
        }
        
        if (n == 4) twoNum = 2;
        if (n == 2) twoNum = 1;
        return (int)Math.pow(3, threeNum) * (int)Math.pow(2, twoNum);
    }
}