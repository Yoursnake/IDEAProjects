/*
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int currNodeNum = 1;    // 当前层的结点数
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            int nextNodeNum = 0;

            for (int i = 0; i < currNodeNum; i++) {
                TreeNode node = queue.poll();
                currList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                    nextNodeNum++;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    nextNodeNum++;
                }
            }

            currNodeNum = nextNodeNum;
            stack.push(currList);
        }

        while (!stack.empty()) result.add(stack.pop());

        return result;
    }
}
