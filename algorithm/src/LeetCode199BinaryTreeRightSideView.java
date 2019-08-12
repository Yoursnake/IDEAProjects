/*
Given a binary tree, imagine yourself standing on the right side
of it, return the values of the nodes you can see ordered from
top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]

Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */

import java.util.ArrayList;
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
public class LeetCode199BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int nextEleNum = 0; // 用于计算下一层有多少个节点
        int currEleNum = 1; // 当前层有多少个节点
        int count = 0;      // 计数，当前层数到第几个
        queue.offer(root);
        result.add(root.val);

        // BFS
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.right != null) {
                nextEleNum++;
                queue.offer(curr.right);
            }
            if (curr.left != null) {
                nextEleNum++;
                queue.offer(curr.left);
            }

            count++;
            // 当数完当前层的节点数，下一层的第一个就是从右边看见的
            // 重新更新 currEleMent 和 nextElement
            if (count == currEleNum) {
                count = 0;
                currEleNum = nextEleNum;
                nextEleNum = 0;

                if (!queue.isEmpty()) result.add(queue.peek().val);
            }
        }

        return result;
    }
}
