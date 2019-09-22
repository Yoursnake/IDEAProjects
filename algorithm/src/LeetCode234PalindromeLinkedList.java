/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode234PalindromeLinkedList {
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	// 用快慢指针找到中点，然后将后半部分 reverse，然后一一比较: 99%
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		if (fast == null || fast.next == null) return true;

		// 快慢指针找中点，slow 所在位置即中点
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode point = slow.next;
		slow.next = null;

		ListNode pre = point;
        point = point.next;
        pre.next = null;

		// reverse
		while (point != null) {
			ListNode tmp = point.next;
			point.next = pre;
			pre = point;
			point = tmp;
		}

		while (pre != null) {
			if (pre.val != head.val) return false;

			pre = pre.next;
			head = head.next;
		}

		return true;
	}
}