/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination 
should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

import java.util.List;
import java.util.ArrayList;

public class LeetCode216CombinationSumIII {
	// DFS: 100%
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        if (k > 9 || n > 45) return result;

        DFS(result, k, n, 1, 0, 0, currList);
        return result;
    }

    private void DFS(List<List<Integer>> result, int k, int n, int index, int last, int currSum, List<Integer> currList) {
    	if (index > k) {
    		if (currSum == n) {
    			List<Integer> tmp = new ArrayList<>(currList);
    			result.add(tmp);
    		} else {
    			return;
    		}
    	}

    	// 注意这里的边界条件
    	for (int i = last + 1; i < 10 - (k - index); i++) {
    		currSum += i;
    		if (currSum > n) {
    			return;
    		} else {
    			currList.add(i);
    			DFS(result, k, n, index + 1, i, currSum, currList);
    			currList.remove(currList.size() - 1);
    		}
			currSum -= i;
    	}
    }
}