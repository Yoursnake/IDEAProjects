/*
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
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
public class LeetCode098ValidateBinarySearchTree {
//    public boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        preOrderTraversal(list, root);
//
//        // 如果 list 无序，则不是 BST
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i + 1) <= list.get(i)) return false;
//        }
//
//        return true;
//    }
//
//    // 前序遍历，把遍历元素存储在 list 中
//    private void preOrderTraversal(List<Integer> list, TreeNode node) {
//        if (node == null) return;
//
//        preOrderTraversal(list, node.left);
//        list.add(node.val);
//        preOrderTraversal(list, node.right);
//    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    // 中序遍历做法
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
