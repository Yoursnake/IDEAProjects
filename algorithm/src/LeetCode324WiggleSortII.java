/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

import java.util.*;

public class LeetCode324WiggleSortII {
	// 先排序找中位数，然后偶数索引填充小于中位数的数，奇数索引填充大于中位数的数，填充的时候要逆序，不然像 [4 5 5 6] 这样的会出错
	// O(nlogn) O(n) 100% 3ms
	public void wiggleSort(int[] nums) {
		int[] tmp = Arrays.copyOf(nums, nums.length);
		Arrays.sort(tmp);

		int mid = (nums.length - 1) / 2;

		for (int i = 0, j = mid; i < nums.length; i = i + 2, j--) {
			nums[i] = tmp[j];
		}

		for (int i = 1, j = nums.length - 1; i < nums.length; i = i + 2, j--) {
			nums[i] = tmp[j];
		}
	}
}