/*
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findList(result, curr, candidates, 0, target);

        return result;
    }

    // 回溯法
    public void findList(List<List<Integer>> result, List<Integer> curr, int[] candidates, int begin, int target) {
        if (target == 0) {
            if (!result.contains(curr))
                result.add(curr);
        }

        for (int i = begin; i < candidates.length; i++) {
            int newTarget = target - candidates[i];

            // 这一步很关键
            if (newTarget < 0) {
                break;
            }

            List<Integer> temp = new ArrayList<>(curr);
            temp.add(candidates[i]);
            findList(result, temp, candidates, i + 1, newTarget);
        }
    }

}
