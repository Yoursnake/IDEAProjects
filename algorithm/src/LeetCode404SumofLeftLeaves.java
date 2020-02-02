/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 
respectively. Return 24.
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
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, false);
    }
    
    private int dfs(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft) return node.val;
        
        int left = (node.left == null) ? 0 : dfs(node.left, true);
        int right = (node.right == null) ? 0 : dfs(node.right, false);
        
        return left + right;
    }
}
