/*
There are n bulbs that are initially off. You first turn on all the bulbs. 
Then, you turn off every second bulb. On the third round, you toggle every 
third bulb (turning on if it's off or turning off if it's on). For the i-th 
round, you toggle every i bulb. For the n-th round, you only toggle the last 
bulb. Find how many bulbs are on after n rounds.

Example:

Input: 3
Output: 1 

Explanation: 
At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
*/

public class LeetCode319BulbSwitcher {
	// // 0% 1293ms	列举出前几次然后找规律即可，发现只要是平方数就会亮
	// public int bulbSwitch(int n) {
 //        int res = 0;
        
 //        for (int i = 1; i <= n; i++) {
 //            if (Math.sqrt(i) == (int)Math.sqrt(i)) res++;
 //        }
        
 //        return res;
 //    }

	// // 0% 0ms
	// public int bulbSwitch(int n) {
 //        int res = 1;
 //        while (res * res <= n) ++res;
 //        return res - 1;
 //    }

	public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}