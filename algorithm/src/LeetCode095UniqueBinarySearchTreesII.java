/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode095UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        else return generate(1, n);
    }

    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> result = new ArrayList<>();

        if (left > right) {
            result.add(null);   // 这步比较关键，相当于是最后一层的子树
            return result;
        }

        for (int i = left; i <= right; i++) {
            // 分别生成左子树和右子树的所有可能
            List<TreeNode> leftResult = generate(left, i - 1);
            List<TreeNode> rightResult = generate(i + 1, right);

            for (int j = 0; j < leftResult.size(); j++) {
                for (int k = 0; k < rightResult.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftResult.get(j);
                    root.right = rightResult.get(k);
                    result.add(root);
                }
            }
        }

        return result;
    }
}
