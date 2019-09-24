/*
Given an array nums, there is a sliding window of size k which 
is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding 
window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 

Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size 
for non-empty array.

Follow up:
Could you solve it in linear time?
*/

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode239SlidingWindowMaximum {
    // Deque: 40.71%
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if (nums.length == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();	// 存储索引
        int[] res = new int[nums.length - k + 1];

        // 保证降序排序
        for (int i = 0; i < nums.length; i++) {
            // 每次进新数，看队首是否是要删除的
        	if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.pollFirst();
        	// 新数和队尾数比较，要是队尾小就出队
        	while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();

        	deque.offerLast(i);

        	if (i >= k - 1) res[i - k + 1] = nums[deque.peekFirst()];
        }

        return res;
    }

//    // PriorityQueue -- Heap: 22.48% O(n^2) (因为heap的remove时间为 O(n))
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0) return new int[0];
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        int[] res = new int[nums.length - k + 1];
//
//        for (int i = 0; i < k; i++) queue.add(nums[i]);
//        res[0] = queue.peek();
//
//        for (int i = 1; i < nums.length - k + 1; i++) {
//            queue.remove(nums[i - 1]);
//            queue.add(nums[i + k - 1]);
//            res[i] = queue.peek();
//        }
//
//        return res;
//    }

//    // BST: 31.28% O(nlogk)
//	public int[] maxSlidingWindow(int[] nums, int k) {
//	    if (nums.length == 0) return new int[0];
//
//		int[] res = new int[nums.length - k + 1];
//		BST bst = new BST(nums[0]);
//		for (int i = 1; i < k; i++) bst.add(nums[i]);
//		res[0] = bst.max();
//
//		for (int i = 1; i < nums.length - k + 1; i++) {
//			bst.remove(nums[i - 1]);
//			bst.add(nums[i + k - 1]);
//			res[i] = bst.max();
//		}
//
//		return res;
//	}
//
//	private class BST {
//		private class TreeNode {
//			TreeNode left;
//			TreeNode right;
//			int val;
//
//			public TreeNode(int x) {this.val = x;}
//		}
//
//		private TreeNode root;
//
//		public BST(int x) {
//			this.root = new TreeNode(x);
//		}
//
//		public void add(int x) {
//		    if (this.root == null) {
//		        this.root = new TreeNode(x);
//		        return;
//            }
//
//			TreeNode point = this.root;
//
//			while (true) {
//				if (x < point.val) {
//					if (point.left == null) {
//						point.left = new TreeNode(x);
//                        break;
//                    }
//					else {
//						point = point.left;
//					}
//				} else {
//					if (point.right == null) {
//						point.right = new TreeNode(x);
//                        break;
//                    }
//					else {
//						point = point.right;
//					}
//				}
//			}
//		}
//
//		public void remove(int x) {
//			this.root = this.deleteNode(this.root, x);
//		}
//
//		public int max() {
//			return this.findMax(this.root);
//		}
//
//		private TreeNode deleteNode(TreeNode root, int x) {
//			if (root == null) return root;
//
//			if (x < root.val) {
//				root.left = this.deleteNode(root.left, x);
//				return root;
//			}
//
//			if (x > root.val) {
//				root.right = this.deleteNode(root.right, x);
//				return root;
//			}
//
//			if (root.left == null && root.right == null) {
//				root = null;
//				return root;
//			}
//
//			if (root.left == null && root.right != null) {
//				root = root.right;
//				return root;
//			}
//
//			if (root.left != null && root.right == null) {
//				root = root.left;
//				return root;
//			}
//
//			if (root.left != null && root.right != null) {
//				int leftMax = this.findMax(root.left);
//				root.val = leftMax;
//				root.left = this.deleteNode(root.left, leftMax);
//				return root;
//			}
//
//			return root;
//		}
//
//		private int findMax(TreeNode root) {
//			if (root.right == null) return root.val;
//			else return this.findMax(root.right);
//		}
//	}
}