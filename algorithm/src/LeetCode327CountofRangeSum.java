/*
Given an integer array nums, return the number of range sums 
that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums 
between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n^2) is trivial. You MUST do better than that.

Example:

Input: nums = [-2,5,-1], lower = -2, upper = 2,
Output: 3 
Explanation: The three ranges are : [0,0], [2,2], [0,2] and 
their respective sums are: -2, -1, 2.
*/

public class LeetCode327CountofRangeSum {
	// // brute force: O(n^2) 117ms 10%
	// public int countRangeSum(int[] nums, int lower, int upper) {
	// 	int len = nums.length;
	// 	int res = 0;

	// 	for (int i = 0; i < len; i++) {
	// 		long sum = 0;
	// 		for (int j = i; j < len; j++) {
	// 			sum += nums[j];
	// 			if (sum >= lower && sum <= upper) res++;
	// 		}
	// 	}

	// 	return res;
	// }

	// MergeSort: 7ms 87%
	// https://leetcode.com/problems/count-of-range-sum/discuss/77990/Share-my-solution
	public int countRangeSum(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length + 1];

		for (int i = 0; i < nums.length; i++)
			sums[i + 1] = sums[i] + nums[i];

		return countWithMergeSort(sums, 0, nums.length + 1, lower, upper);
	}

	// 归并排序并计算 rangesum 的个数
	private int countWithMergeSort(long[] sums, int start, int end, int lower, int upper) {
		if (end - start <= 1) return 0;
		int mid = start + (end - start) / 2;
		// 下面这行代码相当于把左半部分和右半部分已经进行排序
		int cnt = countWithMergeSort(sums, start, mid, lower, upper) + countWithMergeSort(sums, mid, end, lower, upper);
		long[] cache = new long[end - start];	// 用于给数组排序的

		// 这里的 cache 相当于做了归并这个操作
		int j = mid, k = mid, t = mid;
		for (int i = start, r = 0; i < mid; i++) {
			while (j < end && sums[j] - sums[i] < lower) j++;		// 找到第一个大于等于 lower 的值
			while (k < end && sums[k] - sums[i] <= upper) k++;		// 找到第一个大于 upper 的值
			while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];	// 找到所有小于当前 i 的值放入 cache，然后在后面加入 i 的值（相当于归并）
			cache[r++] = sums[i];
			cnt += (k - j);
		}

		// 这步的目的是最后可能有一小部分 sums 中的值未载入到 cache，所以直接用 cache 的值覆盖掉前面的值
		System.arraycopy(cache, 0, sums, start, t - start);		
		return cnt;
	}
}