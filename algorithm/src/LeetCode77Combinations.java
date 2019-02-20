/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < n; i++) {
            numList.add(i + 1);
        }

        combineNum(result, curr, 0, n, index, k);
        return result;
    }

    void combineNum(List<List<Integer>> result, List<Integer> curr, int start, int n, int index, int k) {
        if (index == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < n; i++) {
//            List<Integer> tempCurr = new ArrayList<>(curr);
//            tempCurr.add(i + 1);
            curr.add(i + 1);
            combineNum(result, curr, i + 1, n, index + 1, k);
            curr.remove(curr.size() - 1);
        }
    }
}
