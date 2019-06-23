/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

import java.util.HashMap;

public class LeetCode128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 1;

        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int leftCount = map.getOrDefault(num - 1, 0);
            int rightCount = map.getOrDefault(num + 1, 0);
            int sum = leftCount + rightCount + 1;
            map.put(num, sum);
            map.put(num - leftCount, sum);
            map.put(num + rightCount, sum);

            result = Math.max(result, sum);
        }

        return result;
    }
}
