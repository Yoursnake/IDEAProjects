/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
import java.util.ArrayList;
import java.util.List;

public class LeetCode078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        result.add(new ArrayList<>());

        findSubsets(result, curr, nums, 0);
        return result;
    }

    // 回溯法
    void findSubsets(List<List<Integer>> result, List<Integer> curr, int[] nums, int start) {

        int numsLen = nums.length;
        for (int i = start; i < numsLen; i++) {
            curr.add(nums[i]);
            result.add(new ArrayList<>(curr));  // 这里就要添加 curr
            findSubsets(result, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
