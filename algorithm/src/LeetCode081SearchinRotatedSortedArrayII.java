/*
Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 */
public class LeetCode081SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[low]) {    // 升序
                if (target < nums[mid] && target >= nums[low]) { // target在升序区间
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[low]) { // 非升序
                if (target > nums[mid] && target <= nums[high]) { // target在升序区间
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {    // 与 LeetCode31 的区别之处
                low++;
            }
        }

        return false;
    }

}
