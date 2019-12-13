/*
here is a list of sorted integers from 1 to n. Starting from left to right, 
remove the first number and every other number afterward until you reach the 
end of the list.

Repeat the previous step again, but this time from right to left, remove the 
right most number and every other number from the remaining numbers.

We keep repeating the steps again, alternating left to right and right to left, 
until a single number remains.

Find the last number that remains starting with a list of length n.

Example:

Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

Output:
6
*/

import java.util.*;

public class LeetCode390EliminationGame {
	// brute force: TLE
	// public int lastRemaining(int n) {
	// 	List<Integer> list = new ArrayList<>();
	// 	boolean flag = true;	// true is left->right, false is right->left

	// 	for (int i = 1; i <= n; i++) {
	// 		list.add(i);
	// 	}

	// 	while (list.size() != 1) {
	// 		if (flag) {
	// 			int i = 0;
	// 			while (i < list.size()) {
	// 				list.remove(i);
	// 				i++;
	// 			}
	// 			flag = false;
	// 		} else {
	// 			int i = list.size() - 1;
	// 			while (i >= 0) {
	// 				list.remove(i);
	// 				i = i - 2;
	// 			}
	// 			flag = true;
	// 		}
	// 	}

	// 	return list.get(0);
	// }

	// Divide: O(logn) 2ms 100%
	// 参考：https://leetcode.com/problems/elimination-game/discuss/87119/JAVA%3A-Easiest-solution-O(logN)-with-explanation
	public int lastRemaining(int n) {
		boolean left = true;	// 表示是否从左开始遍历
		int remaining = n;		// 表示还剩下多少数，每次遍历都要除以2
		int head = 1;			// head 表示当前遍历后时开头的元素是多少
		int step = 1;			// step 表示该次删除一步走多长，每次遍历都要乘2

		while (remaining != 1) {
			// 如果从左开始遍历，或者从右开始遍历且遍历前的元素为奇数，则head一定会改变，不然head不会改变
			if (left || remaining % 2 == 1) {
				head += step;
			}
			remaining /= 2;
			step *= 2;
			left = !left;
		}

		return head;
	}
}