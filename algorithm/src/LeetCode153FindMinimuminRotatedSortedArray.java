/*
Suppose an array sorted in ascending order is rotated at some pivot
unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1

Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */

public class LeetCode153FindMinimuminRotatedSortedArray {

    // divide 100%
    public int findMin(int[] nums) {
        int len = nums.length;
        int mid = (0 + len - 1) / 2;

        // 先判断是否是单调的，如果不单调，直接用二分搜索找转折点即可
        if (nums[mid] >= nums[0] && nums[mid] <= nums[len - 1]) return nums[0];
        else return findPivot(nums, 0, nums.length - 1);
    }

    // 二分搜索
    private int findPivot(int[] nums, int begin, int end) {
        int mid = (begin + end) / 2;
        // 找到转折点就 return，mid+1一定是存在的
        if (nums[mid] > nums[mid + 1]) return nums[mid + 1];

        // 左边单调，证明转折点在右边，不单调，则转折点在左边
        if (nums[begin] < nums[mid]) return findPivot(nums, mid + 1, end);
        else return findPivot(nums, begin, mid);
    }
}
