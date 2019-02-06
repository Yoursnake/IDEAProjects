/*
Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class LeetCode53MaximumSubarray {

    // 动态规划
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] >= nums[i]) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
