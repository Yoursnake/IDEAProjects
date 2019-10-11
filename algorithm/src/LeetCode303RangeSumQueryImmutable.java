/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

// 79% 51ms
public class LeetCode303RangeSumQueryImmutable {
	private int[] cumsum;	// 前 i 个的累加和

	public LeetCode303RangeSumQueryImmutable(int[] nums) {
		this.cumsum = new int[nums.length];

		if (nums.length > 0) {	// 防止长度为 0 引起的越界
			this.cumsum[0] = nums[0];

			for (int i = 1; i < nums.length; i++) {
				this.cumsum[i] = this.cumsum[i - 1] + nums[i];
			}
		}
	}

	public int sumRange(int i, int j) {
		if (i == 0) return cumsum[j];	// 防止 i 等于 0 引起的越界
		else return cumsum[j] - cumsum[i - 1];
	}
}
