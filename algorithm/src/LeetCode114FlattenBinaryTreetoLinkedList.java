/*
    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode114FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
//        if (root == null) return;
//
//        LinkedList<Integer> list = new LinkedList<>();
//        findFlatten(list, root);
//
//        TreeNode curr = root;
//
//        for (int i = 1; i < list.size(); i++) {
//            curr.left = null;
//            curr.right = new TreeNode(list.get(i));
//            curr = curr.right;
//        }
        findFlatten(root);
    }

    // 前序遍历，用 list 存储，然后直接修改 root
    private void findFlatten(LinkedList<Integer> list, TreeNode root) {
        if (root == null) return;

        list.add(root.val);
        findFlatten(list, root.left);
        findFlatten(list, root.right);
    }

    // 递归方法，root 右子树设为 左子树和右子树的结果，左子树设为 null
    private TreeNode findFlatten(TreeNode root) {
        if (root == null) return null;

        TreeNode left = findFlatten(root.left);
        TreeNode right = findFlatten(root.right);
        root.left = null;
        root.right = left;

        TreeNode temp = root;
        while (temp.right != null) temp = temp.right;
        temp.right = right;

        return root;
    }
}
