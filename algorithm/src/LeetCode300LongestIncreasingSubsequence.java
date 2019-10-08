/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/

import java.util.*;

public class LeetCode300LongestIncreasingSubsequence {
	// // DP: O(n^2) 20% 15ms   dp[i] = max(dp[j] + 1)  j = i+1, i+2, ..., n  
	// public int lengthOfLIS(int[] nums) {
	// 	if (nums.length == 0) return 0;

	// 	int[] dp = new int[nums.length];	// 表示该位到结尾的最长递增子序列
	// 	int maxLen = 0;

	// 	for (int i = nums.length - 1; i >= 0; i--) {
	// 		dp[i] = 1;

	// 		for (int j = nums.length - 1; j > i; j--) {
	// 			if (nums[i] < nums[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
	// 		}

	// 		if (maxLen < dp[i]) maxLen = dp[i];
	// 	}

	// 	return maxLen;
	// }

	// Greed + Divide: O(nlogn) 93% 1ms
	// 维护一个有序一维数组，当新数大于数组中最后一个数，则 add 该数，
	// 否则使用二分查找找到第一个比该数大的数，并进行替换，最后返回这个二维数组的长度
	// 感想：这个方法有点奇特，看了网上的解析也不是很懂，但是自己试了几个发现确实是这个规律
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) return 0;

		List<Integer> list = new ArrayList<>();
		list.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > list.get(list.size() - 1)) {
				list.add(nums[i]);
			} else {
				int left = 0;
				int right = list.size() - 1;

				while (left < right) {
					int mid = (left + right) / 2;
					if (nums[i] > list.get[mid]) left = mid + 1;
					else right = mid;
				}

				list.set(mid, nums[i]);
			}
		}

		return list.size();
	}
}