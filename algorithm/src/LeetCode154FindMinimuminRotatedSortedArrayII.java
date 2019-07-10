/*
Suppose an array sorted in ascending order is rotated at some pivot
unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1

Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
 */

public class LeetCode154FindMinimuminRotatedSortedArrayII {
    // divide 100%
    public int findMin(int[] nums) {
        int len = nums.length;
        int mid = (0 + len - 1) / 2;

        // 由于 findPivot 只可能找到 0 后面的索引，所以最后要和 0 做比较
        return Math.min(nums[0], findPivot(nums, 0, len - 1));
    }

    private int findPivot(int[] nums, int begin, int end) {
        // 在一半单调情况下的收敛条件
        if (begin == end) return nums[begin];

        // 在一半非单调条件下的收敛条件
        int mid = (begin + end) / 2;
        if (nums[mid] > nums[mid + 1]) return nums[mid + 1];

        // 和没有重复的区别在于相等的情况
        // 如果相等的话，进行二分然后取较小值
        // 找到的 pivot 一定比另一半找到的最小值小
        if (nums[begin] < nums[mid]) return findPivot(nums, mid + 1, end);
        else if (nums[begin] > nums[mid]) return findPivot(nums, begin, mid);
        else return Math.min(findPivot(nums, begin, mid), findPivot(nums, mid + 1, end));
    }
}
