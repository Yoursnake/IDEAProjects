/*
Find the kth largest element in an unsorted array. Note that it is the kth
largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

import java.util.Random;

public class LeetCode215KthLargestElementInAnArray {
//    // 直接排序：88%
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

    private Random r = new Random();

    // 快速排序思想：35.55%，使用随机快速排序后：99%
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int left, int right) {
        int len = nums.length;
        int mid = partition(nums, k, left, right);
        if (mid == len - k) return nums[len - k];
        else if (mid < len - k) return findKthLargest(nums, k, mid + 1, right);
        else return findKthLargest(nums, k, left, mid - 1);
    }

    private int partition(int[] nums, int k, int left, int right) {
        // random quicksort
        if (left != right) {    // 因为 r.nextInt 的输入需要正数
            int randomIndex = left + r.nextInt(right - left);
            if (randomIndex != left) {
                int tmp = nums[left];
                nums[left] = nums[randomIndex];
                nums[randomIndex] = tmp;
            }
        }

        int pivot = nums[left];
        int i = left, j = right;

        while (i < j) {
            while (nums[j] >= pivot && i < j) j--;
            while (nums[i] <= pivot && i < j) i++;

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                nums[left] = nums[j];
                nums[j] = pivot;
            }
        }

        return j;
    }
}
