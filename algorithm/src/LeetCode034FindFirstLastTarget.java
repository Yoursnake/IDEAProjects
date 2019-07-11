/*
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class LeetCode034FindFirstLastTarget {
    public int[] searchRange(int[] nums, int target) {
        int end = nums.length - 1;
        int index = findTarget(nums, target, 0, end);

        // 如果找不到直接返回 [-1, -1]
        if (index == -1) {
            int[] result = {-1, -1};
            return result;
        }

        boolean isFoundFirst = false;
        boolean isFoundLast = false;

        int firstIndex = index;
        int lastIndex = index;
        int firstBound = index - 1;
        int lastBound = index + 1;


        while (true) {

            // 如果没找到第一个就继续找
            if (!isFoundFirst) {
                int temp = firstIndex;  // 先保存前一个索引
                firstIndex = findTarget(nums, target, 0, firstBound);
                if (firstIndex == -1) {
                    firstIndex = temp;  // 如果没找到表示前一个索引就是第一个
                    isFoundFirst = true;
                } else {
                    firstBound = firstIndex - 1;    // 如果找到了，改变边界继续查找
                }
            }

            // 如果没找到最后一个就继续找
            if (!isFoundLast) {
                int temp = lastIndex;
                lastIndex = findTarget(nums, target, lastBound, end);
                if (lastIndex == -1) {
                    lastIndex = temp;
                    isFoundLast = true;
                } else {
                    lastBound = lastIndex + 1;
                }
            }

            if (isFoundFirst && isFoundLast) break;
        }

        int[] result = {firstIndex, lastIndex};
        return result;
    }

    private int findTarget(int[] nums, int target, int begin, int end) {
        // 如果 begin > end 则找不到（边界条件）
        if (begin > end) {
            return -1;
        }

        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return findTarget(nums, target, begin, mid - 1);
        } else{
            return findTarget(nums, target, mid + 1, end);
        }
    }
}
