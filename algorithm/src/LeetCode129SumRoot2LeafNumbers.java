/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
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
public class LeetCode129SumRoot2LeafNumbers {
//    // BFS     1 ms   ?? why BFS is slower than DFS
//    public int sumNumbers(TreeNode root) {
//        if (root == null) return 0;
//
//        int result = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode curr = queue.poll();
//
//            if (curr.left != null) {
//                curr.left.val += curr.val * 10;
//                queue.offer(curr.left);
//            }
//
//            if (curr.right != null) {
//                curr.right.val += curr.val * 10;
//                queue.offer(curr.right);
//            }
//
//            if (curr.left == null && curr.right == null)
//                result += curr.val;
//        }
//
//        return result;
//    }

    // DFS    0 ms
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        int result = Travel(root, 0);
        return result;
    }

    // 递归
    private int Travel(TreeNode root, int preVal) {
        if (root.left == null && root.right == null) return preVal * 10 + root.val;

        preVal = root.val + preVal * 10;
        int sum = 0;

        if (root.left != null) sum += Travel(root.left, preVal);
        if (root.right != null) sum += Travel(root.right, preVal);
        return sum;
    }
}
