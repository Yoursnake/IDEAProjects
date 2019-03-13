/*
Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        // 左子树和右子树必须平衡
        if (isBalanced(root.left) && isBalanced(root.right)) {
            // 左子树深度和右子树深度差 0 或 1
            if (Math.abs(nodeDepth(root.left) - nodeDepth(root.right)) == 1
                    || nodeDepth(root.left) == nodeDepth(root.right)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    private int nodeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(nodeDepth(root.left), nodeDepth(root.right)) + 1;
    }
}
