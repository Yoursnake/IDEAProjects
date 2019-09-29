/*
Given an array nums containing n + 1 integers where each integer is 
between 1 and n (inclusive), prove that at least one duplicate number 
must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2

Example 2:

Input: [3,1,3,4,2]
Output: 3

Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n^2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

public class LeetCode287FindtheDuplicateNumber {

	// 快慢指针: O(n) 100% 0ms
	// https://www.jianshu.com/p/f7db34bd10e1
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// 从 0 开始同时走，slow 和 fast 同时到达入口
		fast = 0;
		while (fast != slow) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}

	// // divide: O(nlogn) 16.51% 5ms
	// // 这个二分法比较神奇，left right 表示查询范围的左右边界
	// // 如果 <= mid 的数比 mid 多，表明查询范围因改为 [mid+1,right]
	// // 否则改为 [left, mid]
	// public int findDuplicate(int[] nums) {
	// 	int left = 1;
	// 	int right = nums.length - 1;

	// 	while (left < right) {
	// 		int mid = (right - left) / 2 + left;
	// 		int count = 0;

	// 		for (int num : nums) {
	// 			if (num <= mid) count++;
	// 		}

	// 		if (count > mid) right = mid;
	// 		else left = mid + 1;
	// 	}

	// 	return left;
	// }
}