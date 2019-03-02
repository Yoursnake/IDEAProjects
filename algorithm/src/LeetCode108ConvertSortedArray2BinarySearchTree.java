/*
Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
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
public class LeetCode108ConvertSortedArray2BinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArray2BST(nums, 0, nums.length - 1);
    }

    // 把 nums 中 low~high 的数字构造成一颗 BST
    private TreeNode sortedArray2BST(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArray2BST(nums, low, mid - 1);
        root.right = sortedArray2BST(nums, mid + 1, high);
        return root;
    }
}
