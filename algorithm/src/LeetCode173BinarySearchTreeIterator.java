/*
Implement an iterator over a binary search tree (BST). Your iterator
will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false


Note:
1. next() and hasNext() should run in average O(1) time and uses O(h) memory,
where h is the height of the tree.
2. You may assume that next() call will always be valid, that is, there will
be at least a next smallest number in the BST when next() is called.
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

import java.util.Stack;

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
public class LeetCode173BinarySearchTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Stack<TreeNode> stack = new Stack<>();

    public LeetCode173BinarySearchTreeIterator(TreeNode root) {
        pushAllLeft(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode nextNode = stack.pop();
        if (nextNode.right != null) pushAllLeft(nextNode.right);
        return nextNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        else return true;
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
