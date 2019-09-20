/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), 
but you can’t invert a binary tree on a whiteboard so f*** off.
*/

import java.util.Queue;
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
public class LeetCode226InvertBinaryTree {
	static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
	}

	// // DFS: 100%  
	// public TreeNode invertTree(TreeNode root) {
	// 	if (root == null) return null;
	// 	if (root.left == null && root.right == null) return root;
		
	// 	TreeNode left = root.left;
	// 	TreeNode right = root.right;

	// 	root.left = invertTree(right);
	// 	root.right = invertTree(left);
		
	// 	return root;
	// }

	// BFS: 100%
	public TreeNode invertTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			if (currNode == null) continue;

			TreeNode left = currNode.left;
			TreeNode right = currNode.right;

			currNode.left = right;
			currNode.right = left;

			queue.offer(left);
			queue.offer(right);
		}

		return root;
	}
}