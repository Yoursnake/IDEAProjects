/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

注意：！！！这里的 My number 是题目让我们去猜的数字，而不是我们正在猜的数字

Example :

Input: n = 10, pick = 6
Output: 6
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class LeetCode374GuessNumberHigherorLower {
	// 二分法：O(logn) 0ms 100%
	public int guessNumber(int n) {
        int left = 1, right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 1) left = mid + 1;
            else if (guess(mid) == -1) right = mid - 1;
            else return mid;
        }
        
        return -1;
    }

    // 这个是为了让项目不报错，函数本身没有意义
    private int guess(int n) {
    	return -1;
    }
}