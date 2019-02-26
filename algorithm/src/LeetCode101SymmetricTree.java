/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3

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
public class LeetCode101SymmetricTree {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//
//        if (root.left.val == root.right.val) return isSymmetric(root.left, root.right);
//        else return false;
//    }
//
//    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
//        boolean res1, res2;
//
//        if (node1.left == null && node2.right != null) return false;
//        if (node1.left != null && node2.right == null) return false;
//        if (node1.right == null && node2.left != null) return false;
//        if (node1.right != null && node2.left == null) return false;
//
//        if (node1.left == null && node2.right == null) {
//            res1 = true;
//        } else {
//            if (node1.left.val == node2.right.val) res1 = isSymmetric(node1.left, node2.right);
//            else res1 = false;
//        }
//
//        if (node1.right == null && node2.left == null) {
//            res2 = true;
//        } else {
//            if (node1.right.val == node2.left.val) res2 = isSymmetric(node1.right, node2.left);
//            else res2 = false;
//        }
//
//        return res1 && res2;
//    }

    // update
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}
