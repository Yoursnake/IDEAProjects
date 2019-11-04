/*
Given a singly linked list, group all odd nodes together followed 
by the even nodes. Please note here we are talking about the node 
number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) 
space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode328OddEvenLinkedList {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	// O(nodes) O(1) 0ms 100%
	public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null || head.next.next == null) return head;

        ListNode head1 = head;
        ListNode head2 = head.next;
        // point1 和 point2 间隔一个 node
        ListNode point1 = head;
        ListNode point2 = head.next.next;
        ListNode mid = head.next;

        boolean odd = true;		// 表示现在在处理奇数还是偶数

        while (true) {
        	point1.next = point2;
        	if (point2.next == null) {
        		if (odd) {
        			mid.next = null;
        			point2.next = head2;
        		} else {
        			mid.next = head2;
        		}

        		break;
        	}

        	point1 = mid;
        	mid = point1.next;
        	point2 = point2.next;
            odd = !odd;
        }

        return head;
    }
}