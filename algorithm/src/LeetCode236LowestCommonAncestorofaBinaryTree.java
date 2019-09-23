/*
Given a binary tree, find the lowest common ancestor (LCA) of two 
given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common 
ancestor is defined between two nodes p and q as the lowest node in 
T that has both p and q as descendants (where we allow a node to be 
a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

     3
   /   \
  5    1
 / \  / \
6  2 0  8
  /\
 7 4


Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
*/

import java.util.List;
import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode236LowestCommonAncestorofaBinaryTree {
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	// // 法一：穷举：5.01% 800+ms
	// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	// 	if (root.val == p.val || root.val == q.val) return root;

	// 	if (findTreeNode(root.left, p)) {
	// 		if (findTreeNode(root.left, q)) return lowestCommonAncestor(root.left, p, q);
	// 		else return root;
	// 	} else {
	// 		if (findTreeNode(root.left, q)) return root;
	// 		else return lowestCommonAncestor(root.right, p, q);
	// 	}
	// }

	// private boolean findTreeNode(TreeNode root, TreeNode node) {
	// 	if (root == null) return false;
	// 	if (node.val == root.val) return true;

	// 	return findTreeNode(root.left, node) | findTreeNode(root.right, node);
	// }

	// // 法二：先找路径，然后从后往前找两路径的第一个公共点：20.54%	8ms
	// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	// 	List<List<TreeNode>> paths = new ArrayList<>();
	// 	List<TreeNode> curr = new ArrayList<>();

	// 	findTreeNode(root, p, curr, paths);
	// 	findTreeNode(root, q, curr, paths);

	// 	List<TreeNode> path1 = paths.get(0);
	// 	List<TreeNode> path2 = paths.get(1);
	// 	for (int i = path1.size() - 1; i >= 0; i--) {
	// 		for (int j = path2.size() - 1; j >= 0; j--) {
	// 			if (path1.get(i).val == path2.get(j).val) return path1.get(i);
	// 		}
	// 	}

	// 	return null;
	// }

	// private void findTreeNode(TreeNode root, TreeNode node, List<TreeNode> curr, List<List<TreeNode>> paths) {
	// 	if (root == null) return;
	// 	if (node.val == root.val) {
	// 		List<TreeNode> tmp = new ArrayList<>(curr);
	// 		tmp.add(node);
	// 		paths.add(tmp);
	// 		return;
	// 	}

	// 	curr.add(root);
	// 	findTreeNode(root.left, node, curr, paths);
	// 	findTreeNode(root.right, node, curr, paths);
	// 	curr.remove(curr.size() - 1);
	// }

	// // 法三：直接递归：68.91%	6ms
	// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	// 	if (root == null || root.val == p.val || root.val == q.val) return root;

	// 	TreeNode l = lowestCommonAncestor(root.left, p, q);
	// 	TreeNode r = lowestCommonAncestor(root.right, p, q);

	// 	if (l == null || r == null) return (l == null) ? r : l;
	// 	else return root;
	// }

	// 法四：法三的优化：68.91%	6ms
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root.val == p.val || root.val == q.val) return root;

		TreeNode l = lowestCommonAncestor(root.left, p, q);
		if (l != null && l.val != p.val && l.val != q.val) return l;

		TreeNode r = lowestCommonAncestor(root.right, p, q);
		if (l == null || r == null) return (l == null) ? r : l;
		else return root;
	}
}