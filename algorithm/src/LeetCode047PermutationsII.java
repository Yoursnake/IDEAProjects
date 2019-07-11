/*
Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode047PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        permute(result, curr, nums);

        return result;
    }

    // 回溯法
    private void permute(List<List<Integer>> result, List<Integer> curr, int[] nums) {

        // 使用 HashSet 来存储已经作为该位的数值
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;    // 遇到相同的直接跳过

            List<Integer> temp = new ArrayList<>(curr);
            temp.add(nums[i]);
            set.add(nums[i]);
            int[] afterNums = AfterNums(nums, i);

            // 终止条件
            if (afterNums.length == 0) {
                result.add(temp);
                return;
            }

            permute(result, temp, afterNums);
        }
    }

    // 从数组中取出一个数后组成新数组
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
