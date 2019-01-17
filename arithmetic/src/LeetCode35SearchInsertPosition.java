/*
Example 1:

Input: [1,3,5,6], 5
Output: 2

Example 2:

Input: [1,3,5,6], 2
Output: 1

Example 3:

Input: [1,3,5,6], 7
Output: 4

Example 4:

Input: [1,3,5,6], 0
Output: 0
 */
public class LeetCode35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int end = nums.length - 1;
        int index = findTarget(nums, target, 0, end);

        if (index != -1) {
            return index;
        } else {
            return findInsert(nums, target, 0, end);
        }
    }

    private int findInsert(int[] nums, int target, int begin, int end) {
        // insert 条件为 target < nums[index] && nums[index - 1] < target
        // 则结果为 index，注意边界条件即可

        int mid = (begin + end) / 2;

        if (target < nums[mid]) {
            // 如果 target 小于 mid 且在第一位，则结果必为第一位
            if (mid == begin) {
                return begin;
            }

            // 如果 target 在 mid-1 和 mid 之间，则结果为 mid
            // 否则在 begin ~ mid - 1
            if (nums[mid - 1] < target) {
                return mid;
            } else {
                return findInsert(nums, target, begin, mid - 1);
            }
        } else {
            // 如果 target 大于 mid 且在最后一位，则结果必为最后一位
            // 否则在 mid + 1 ~ end
            if (mid == end) {
                return end + 1;
            } else {
                return findInsert(nums, target, mid + 1, end);
            }
        }
    }

    private int findTarget(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }

        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return findTarget(nums, target, mid + 1, end);
        } else {
            return findTarget(nums, target, 0, mid - 1);
        }
    }
}
