/*
Given an integer array with all positive numbers and no duplicates, 
find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.
*/

import java.util.*;

public class LeetCode377CombinationSumIV {
//	// DP recursive: 1ms 82.23%
//	public int combinationSum4(int[] nums, int target) {
//		Arrays.sort(nums);
////		Map<Integer, Integer> map = new HashMap<>();
//		// 用数组代替 hashmap 可以提速 3ms->1ms
//		int[] map = new int[target + 1];
//		Arrays.fill(map, -1);
//		return count(nums, target, map);
//	}
//
//	private int count(int[] nums, int target, int[] map) {
//		if (map[target] != -1) return map[target];
//		int res = 0;
//
//		for (int num : nums) {
//			if (target > num) {
//				res += count(nums, target - num, map);
//			} else if (target == num) {
//				res++;
//			} else {
//				break;
//			}
//		}
//
//		map[target] = res;
//
//		return res;
//	}

	// DP iterative: 1ms 82.23%
	// dp[i] = sum{dp[i - nums[j]]}
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] dp = new int[target + 1]; // 表示组成 i 有多少种方法
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length && i - nums[j] >= 0; j++) {
				dp[i] += dp[i - nums[j]];
			}
		}

		return dp[target];
	}
}