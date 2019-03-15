/*
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> currList = new ArrayList<>();
        findAllPath(result, currList, root, 0, sum);
        return result;
    }

    private void findAllPath(List<List<Integer>> result, List<Integer> currList, TreeNode currNode, int currSum, int sum) {
        if (currNode.left == null && currNode.right == null) {
            if (currSum + currNode.val == sum) {
                currList.add(currNode.val);
                result.add(currList);
            }
            return;
        }

        currSum = currSum + currNode.val;
        currList.add(currNode.val);
        if (currNode.left != null) {
            List<Integer> tempList = new ArrayList<>(currList);
            findAllPath(result, tempList, currNode.left, currSum, sum);
        }

        if (currNode.right != null) {
            List<Integer> tempList = new ArrayList<>(currList);
            findAllPath(result, tempList, currNode.left, currSum, sum);
        }
    }
}
