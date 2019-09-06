/*
Given an array of n positive integers and a positive integer s, find the
minimal length of a contiguous subarray of which the sum ≥ s. If there
isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2

Explanation: the subarray [4,3] has the minimal length under the problem
constraint.

Follow up:
If you have figured out the O(n) solution, try coding another solution of
which the time complexity is O(n log n).
 */

public class LeetCode209MinimumSizeSubarraySum {

//    // dp[n] = min(dp[n-1], fromLast): O(n^2) 6.46%
//    public int minSubArrayLen(int s, int[] nums) {
//        if (nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        dp[0] = (nums[0] > s) ? 1 : 0;
//
//        for (int i = 1; i < nums.length; i++) {
//            int fromLast = 0;
//            int sum = 0;
//
//            for (int j = i; j >= 0; j--) {
//                sum += nums[j];
//                if (sum >= s) {
//                    fromLast = i - j + 1;
//                    break;
//                }
//            }
//
//            if (dp[i - 1] == 0) dp[i] = fromLast;
//            else dp[i] = Math.min(dp[i - 1], fromLast);
//        }
//
//        return dp[nums.length - 1];
//    }

    // slide window: 99.96%
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;

        int minLen = nums.length;
        int sum = nums[0];
        int left = 0;   // 左指针
        int right = 0;  // 右指针

        while (true) {
            if (sum >= s) {
                int currLen = right - left + 1;
                if (currLen == 1) return currLen;
                if (currLen < minLen) minLen = currLen;

                sum -= nums[left];
                left++;
            } else {
                if (right == nums.length - 1) break;

                right++;
                sum += nums[right];
            }
        }

        if (minLen == nums.length && left == 0) return 0;
        else return minLen;
    }
}
