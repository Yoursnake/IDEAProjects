/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, 
is completely filled, and all nodes in the last level are as far 
left as possible. It can have between 1 and 2h nodes inclusive at 
the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
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
public class LeetCode222CountCompleteTreeNodes {
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	// // 直接用 DFS: 100%
	// public int countNodes(TreeNode root) {
	// 	if (node == null) return 0;
	// 	if (node.left == null && node.right == null) return 1;
	// 	else return 1 + countNodes(node.left) + countNodes(node.right);
	// }

	// 利用完全二叉树的特性 DFS: 100%
	public int countNodes(TreeNode root) {
		TreeNode leftPoint = root, rightPoint = root;
		int leftHeight = 0, rightHeight = 0;

		while (leftPoint != null) {
			leftHeight++;
			leftPoint = leftPoint.left;
		}

		while (rightPoint != null) {
			rightHeight++;
			rightPoint = rightPoint.right;
		}

		if (leftHeight == rightHeight) return 1 >> (leftHeight) - 1;
		else return 1 + countNodes(root.left) + countNodes(root.right);
	}
}