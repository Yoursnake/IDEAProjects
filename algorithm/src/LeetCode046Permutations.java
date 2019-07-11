/*
Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode046Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        permute(result, curr, nums);

        return result;
    }

    // 回溯法
    private void permute(List<List<Integer>> result, List<Integer> curr, int[] nums) {
//        // 终止条件也像这样可以写在开头
//        if (nums.length == 0) {
//            result.add(curr);
//            return;
//        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(curr);
            temp.add(nums[i]);
            int[] afterNums = AfterNums(nums, i);

            // 终止条件
            if (afterNums.length == 0) {
                result.add(temp);
                return;
            }

            permute(result, temp, afterNums);
        }
    }

    private int[] AfterNums(int[] nums, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] afterNums = new int[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        list.remove(index);
        for (int i = 0; i < afterNums.length; i++) {
            afterNums[i] = list.get(i);
        }

        return afterNums;

    }
}
