/*
Write a function to delete a node (except the tail) in a singly 
linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:

4->5->1->9 

Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked 
list should become 4 -> 1 -> 9 after calling your function.

Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked 
list should become 4 -> 5 -> 9 after calling your function.

Note:

The linked list will have at least two elements.
All of the nodes' values will be unique.
The given node will not be the tail and it will always be a valid node of the linked list.
Do not return anything from your function.
*/

import java.util.Queue;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode237DeleteNodeinaLinkedList {
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	// Queue: 100%
	public void deleteNode(ListNode node) {
		Queue<Integer> queue = new LinkedList<>();

		ListNode nullNode = new ListNode(-1);
		nullNode.next = node;

		ListNode pre = nullNode;
		ListNode curr = node;

		while (true) {
			queue.offer(curr.val);
			curr = curr.next;
			if (curr == null) break;
			pre = pre.next;
		}

		pre.next = null;

		while (queue != null) {
			node.val = queue.offer();
		}
	}
}