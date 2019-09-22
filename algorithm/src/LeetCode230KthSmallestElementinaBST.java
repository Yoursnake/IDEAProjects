/*
Given a binary search tree, write a function kthSmallest 
to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often 
and you need to find the kth smallest frequently? How would 
you optimize the kthSmallest routine?
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
public class LeetCode230KthSmallestElementinaBST {
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	// 分治 + DFS: 74.83%
	public int kthSmallest(TreeNode root, int k) {
		int leftNum = countAllNode(root.left);
		if (leftNum + 1 == k) return root.val;
		else if (leftNum + 1 < k) return kthSmallest(root.right, k - leftNum - 1);
		else return kthSmallest(root.left, k - 1);
	}

	private int countAllNode(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		else return countAllNode(root.left) + countAllNode(root.right) + 1;
	}
}