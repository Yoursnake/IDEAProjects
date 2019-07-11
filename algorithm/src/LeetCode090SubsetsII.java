/*
Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode090SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        result.add(new ArrayList<>());

        findSubset(result, curr, nums, 0);
        return result;
    }

    private void findSubset(List<List<Integer>> result, List<Integer> curr, int[] nums, int start) {
        int numsLen = nums.length;

        for (int i = start; i < numsLen; i++) {
            curr.add(nums[i]);
            result.add(new ArrayList<>(curr));
            findSubset(result, curr, nums, i + 1);

            // 这一步是关键，再用回溯深度搜索一遍后，同样的数字不需要再次深度搜索
            for (int j = i + 1; j < numsLen; j++) {
                if (nums[i] == nums[j]) i++;
                else break;
            }

            curr.remove(curr.size() - 1);
        }
    }
}
