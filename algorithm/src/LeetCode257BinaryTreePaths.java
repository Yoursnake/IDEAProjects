/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode257BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// DFS: 100% 1ms
	public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;

		List<String> res = new ArrayList<>();

		DFS(root, res, "");
		
		return res;
	}

	private void DFS(TreeNode root, List<String> res, String curr) {
		if (root.left == null && root.right == null) {
			res.add(curr + root.val);
			return;
		}

		curr = curr + root.val + "->";
		if (root.left != null) DFS(root.left, res, curr);
		if (root.right != null) DFS(root.right, res, curr);
	}
}