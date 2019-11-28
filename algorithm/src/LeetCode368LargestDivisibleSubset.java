/*
Given a set of distinct positive integers, find the largest subset such that 
every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode368LargestDivisibleSubset {
//	// DFS: TLE
//	List<Integer> res = new ArrayList<>();
//
//	public List<Integer> largestDivisibleSubset(int[] nums) {
//		Arrays.sort(nums);
//		List<Integer> curr = new ArrayList<>();
//		curr.add(1);
//		findLargestDFS(nums, 0, curr);
//		res.remove(0);
//		return res;
//	}
//
//	private void findLargestDFS(int[] nums, int idx, List<Integer> curr) {
//		if (idx == nums.length) {
//			if (curr.size() > res.size()) {
//				res = new ArrayList<>(curr);
//			}
//			return;
//		}
//
//		for (int i = idx; i < nums.length; i++) {
//			if (nums[i] % curr.get(curr.size() - 1) == 0) {
//				curr.add(nums[i]);
//				findLargestDFS(nums, i + 1, curr);
//				curr.remove(curr.size() - 1);
//			}
//		}
//
//		if (curr.size() > res.size()) {
//			res = new ArrayList<>(curr);
//		}
//	}

	// DP: O(n^2) 16ms 72%
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;

		int[] dp = new int[nums.length];    // dp 表示到 i 为止元素最大的子集个数
		int[] pre = new int[nums.length];   // 表示第 i 个元素达到 dp[i] 的前缀索引
		Arrays.sort(nums);

		int maxNum = 1;     // 表示最大子集元素个数
		int maxIdx = 0;     // 对应索引
		Arrays.fill(dp, 1);
		Arrays.fill(pre, -1);
		for (int i = 1; i < dp.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						pre[i] = j;
					}
				}
			}

			// 每次计算完 dp[i]，与 maxNum 比较
			if (dp[i] > maxNum) {
				maxNum = dp[i];
				maxIdx = i;
			}
		}

		List<Integer> res = new ArrayList<>();
		int idx = maxIdx;
		while (idx > -1) {
			res.add(nums[idx]);
			idx = pre[idx];
		}

		return res;
	}
}