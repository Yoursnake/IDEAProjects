/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Note:
Try to come up as many solutions as you can, there are at
least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */

public class LeetCode189RotateArray {

//    // 100% time O(n) space O(k)
//    public void rotate(int[] nums, int k) {
//        int numsLen = nums.length;
//        int[] temp = new int[k];  // 用于存储需要移到前面的数组
//        k = k % (nums.length);
//
//        int tempIndex = 0;
//        for (int i = numsLen - k; i < numsLen; i++) {
//            temp[tempIndex++] = nums[i];
//        }
//
//        for (int i = numsLen - 1; i >= k; i--) {
//            nums[i] = nums[i - k];    // 将前面一段数组往后移
//        }
//
//        for (int i = 0; i < k; i++) {
//            nums[i] = temp[i];
//        }
//    }

    // time O(n^2) space O(1)
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            int currNum = nums[nums.length - 1];
            for (int j = nums.length - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = currNum;
        }
    }
}
