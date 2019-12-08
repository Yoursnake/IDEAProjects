/*
A sequence of numbers is called a wiggle sequence if the differences 
between successive numbers strictly alternate between positive and 
negative. The first difference (if one exists) may be either positive 
or negative. A sequence with fewer than two elements is trivially a 
wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences 
(6,-3,5,-7,3) are alternately positive and negative. In contrast, 
[1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because 
its first two differences are positive and the second because its last 
difference is zero.

Given a sequence of integers, return the length of the longest subsequence 
that is a wiggle sequence. A subsequence is obtained by deleting some number 
of elements (eventually, also zero) from the original sequence, leaving the 
remaining elements in their original order.

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.

Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2

Follow up:
Can you do it in O(n) time?
*/

public class LeetCode376WiggleSubsequence {
	// Greedy: O(n) 0ms 100% 
	// 依次往后找，在单调的地方最高点或者最低点计数加 1
	public int wiggleMaxLength(int[] nums) {
		if (nums.length <= 1) return nums.length;

		int idx = 1;
		while (idx < nums.length && nums[idx] == nums[idx - 1]) idx++;	// 先找到第一个和前一个数不单调的数
		if (idx == nums.length) return 1;

		int flag;	// -1 表示上一个是递增，1 表示上一个是递减
		int res = 2;
		if (nums[idx - 1] < nums[idx]) flag = -1;
		else flag = 1;

		for (int i = idx + 1; i < nums.length; i++) {
			if (flag < 0) {
				if (nums[i - 1] > nums[i]) {
					res++;
					flag = 1;
				}
			} else {
				if (nums[i - 1] < nums[i]) {
					res++;
					flag = -1;
				}
			}
		}

		return res;
	}

	// // DP: O(n) 0ms 100%
	// // 参考：https://leetcode.com/problems/wiggle-subsequence/discuss/84843/Easy-understanding-DP-solution-with-O(n)-Java-version
	// public int wiggleMaxLength(int[] nums) {
 //        if (nums.length <= 1) return nums.length;

	// 	int len = nums.length;
	// 	int[] up = new int[len];
	// 	int[] down = new int[len];

	// 	up[0] = 1;		// 到 i 这个元素，最后一个上升节点增加到多少长度
	// 	down[0] = 1;	// 到 i 这个元素，最后一个下降节点增加到多少长度

	// 	for (int i = 1; i < len; i++) {
	// 		if (nums[i] > nums[i - 1]) {
	// 			up[i] = down[i - 1] + 1;
	// 			down[i] = down[i - 1];
	// 		} else if (nums[i] < nums[i - 1]) {
	// 			up[i] = up[i - 1];
	// 			down[i] = up[i - 1] + 1;
	// 		} else {
	// 			up[i] = up[i - 1];
	// 			down[i] = down[i - 1];
	// 		}
	// 	}

	// 	return Math.max(up[len - 1], down[len - 1]);
	// }

}