/*
Given a sorted integer array without duplicates, return the summary
of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous
range.

Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous
range.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.EMPTY_LIST;

        List<String> res = new ArrayList<>();
        int low = nums[0];
        int high = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // 这里要是写成 nums[i] - high > 1 可能会越界
            if (i == nums.length || nums[i] - 1 != high) {
                if (high == low) res.add(String.valueOf(high));
                else res.add(low + "->" + high);
                if (i != nums.length) low = high = nums[i];
            } else {
                high = nums[i];
            }
        }

        return res;
    }
}
