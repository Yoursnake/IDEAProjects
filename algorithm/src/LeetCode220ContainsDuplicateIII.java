/*
Given an array of integers, find out whether there are 
two distinct indices i and j in the array such that the 
absolute difference between nums[i] and nums[j] is at 
most t and the absolute difference between i and j is 
at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
*/

import java.util.Map;
import java.util.HashMap;

public class LeetCode220ContainsDuplicateIII {
	// // slide windows + TreeSet: 29.52%
	// public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	// 	if (k < 1 || t < 0) return false;
	// 	TreeSet<Long> treeSet = new TreeSet<>();

	// 	for (int i = 0; i < nums.length; i++) {
	// 		long n = nums[i];
	// 		if (treeSet.floor(n) != null && n - treeSet.floor(n) <= t ||
	// 			treeSet.ceiling(n) != null && treeSet.ceiling(n) - n <= t)
	// 			return true;

	// 		treeSet.add(n);
	// 		if (i >= t) treeSet.remove((long)nums[i - t]);
	// 	}

	// 	return false;
	// }

	// slide windows + bucket sort: 91.37%
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;

		long min = Integer.MAX_VALUE;
		long max = Integer.MIN_VALUE;

		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		long bucketLen = (long)(t) + 1;     // 这边要是 t = 2147483647，使用 int 会越界
		Map<Long, Long> buckets = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			long m = (nums[i] - min) / bucketLen;	// 当前数所在的桶序号
			if (buckets.containsKey(m)) return true;
			if (buckets.containsKey(m - 1) && nums[i] - buckets.get(m - 1) <= t) return true;
			if (buckets.containsKey(m + 1) && buckets.get(m + 1) - nums[i] <= t) return true;

			buckets.put(m, (long)nums[i]);
			if (i >= k) buckets.remove((nums[i - k] - min) / bucketLen);
		}

		return false;
	}
}