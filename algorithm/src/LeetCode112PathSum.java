/*
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSum(root, 0, sum);
    }

    private boolean hasPathSum(TreeNode currNode, int currSum, int sum) {
        if (currNode.left == null && currNode.right == null) {
            return (currSum + currNode.val) == sum;
        }

        currSum = currSum + currNode.val;

        boolean leftRes = false, rightRes = false;
        if (currNode.left != null) leftRes = hasPathSum(currNode.left, currSum, sum);
        if (currNode.right != null) rightRes = hasPathSum(currNode.right, currSum, sum);
        return leftRes || rightRes;
    }
}
