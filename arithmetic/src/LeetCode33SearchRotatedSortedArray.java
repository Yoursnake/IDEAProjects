/*
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
public class LeetCode33SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int low = 0;
        int len = nums.length;
        int high = len - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[mid] <= nums[high]) {   // 表示升序（等于号很重要）
                    // 如果后半段升序，且target 小于 high，则 target 必在 mid 到 high 间
                    // 不然 target 必在 low 到 mid 间
                    if (target <= nums[high]) low = mid + 1;
                    else high = mid - 1;
                } else {                        // 不是升序，存在旋转点
                    // 如果不是升序，则必在 mid 到旋转点间，也是 mid 到 high 之间
                    low = mid + 1;
                }
            } else {
                if (nums[mid] >= nums[low]) {   // 表示升序
                    if (target >= nums[low]) high = mid - 1;
                    else low = mid + 1;
                } else {                        // 不是升序，存在旋转点
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

}
