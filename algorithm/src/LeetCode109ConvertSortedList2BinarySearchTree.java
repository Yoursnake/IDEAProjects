/*
Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
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
public class LeetCode109ConvertSortedList2BinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> nums = new ArrayList<>();

        do {
            nums.add(head.val);
            head = head.next;
        } while (head != null);

        TreeNode root = sortedList2BST(nums, 0, nums.size() - 1);
        return root;
    }

    private TreeNode sortedList2BST(List<Integer> nums, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedList2BST(nums, low, mid - 1);
        root.right = sortedList2BST(nums, mid + 1, high);

        return root;
    }
}
