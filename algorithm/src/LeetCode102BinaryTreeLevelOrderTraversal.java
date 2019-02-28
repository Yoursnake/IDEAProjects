/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode102BinaryTreeLevelOrderTraversal {
    // BFS，使用队列 queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 由于没有查找，使用 LinkedList 添加速度更快
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        int currLen = 1;    // 当前层有几个元素
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nextLen = 0;    // 下一层的元素个数
            List<Integer> curr = new LinkedList<>();
            for (int i = 0; i < currLen; i++) {
                TreeNode pollNode = queue.poll();
                curr.add(pollNode.val);

                // 遍历当前层的过程中可以计算下一层的元素个数
                if (pollNode.left != null) {
                    nextLen++;
                    queue.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    nextLen++;
                    queue.offer(pollNode.right);
                }
            }

            result.add(curr);
            currLen = nextLen;
        }

        return result;
    }
}
