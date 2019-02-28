/*
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
public class LeetCode103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        int currLen = 1;
        boolean isReverse = false;  // 表示当前元素下面需要正着遍历还是反着遍历
        stack.push(root);

        while (!stack.isEmpty()) {
            int nextLen = 0;
            List<Integer> curr = new LinkedList<>();
            // 新建一个栈，不然会和原来的混叠起来
            Stack<TreeNode> tempStack = new Stack<>();

            for (int i = 0; i < currLen; i++) {
                TreeNode popNode = stack.pop();
                curr.add(popNode.val);

                if (!isReverse) {
                    if (popNode.left != null) {
                        tempStack.push(popNode.left);
                        nextLen++;
                    }

                    if (popNode.right != null) {
                        tempStack.push(popNode.right);
                        nextLen++;
                    }
                } else {
                    if (popNode.right != null) {
                        tempStack.push(popNode.right);
                        nextLen++;
                    }

                    if (popNode.left != null) {
                        tempStack.push(popNode.left);
                        nextLen++;
                    }
                }
            }

            stack = tempStack;
            isReverse = !isReverse;
            currLen = nextLen;
            result.add(curr);
        }

        return result;
    }
}
