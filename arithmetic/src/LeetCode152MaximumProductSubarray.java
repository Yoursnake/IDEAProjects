/*
Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class LeetCode152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxAll = nums[0];
        int maxCur = nums[0];
        int minCur = nums[0];
        int maxLast = maxCur;
        int minLast = minCur;

        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(Math.max(maxLast * nums[i], nums[i]), minLast * nums[i]);
            minCur = Math.min(Math.min(maxLast * nums[i], nums[i]), minLast * nums[i]);
            maxLast = maxCur;
            minLast = minCur;
            maxAll = Math.max(maxCur, maxAll);
        }

        return maxAll;
    }
}
