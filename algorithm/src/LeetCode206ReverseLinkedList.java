/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively.
Could you implement both?
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode206ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    // iteratively
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        ListNode pre = null;
//        ListNode curr = head;
//        ListNode next = head.next;
//
//        while (next != null) {
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//            next = next.next;
//        }
//
//        curr.next = pre;
//        return curr;
//    }

    // recursive
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode curr) {
        if (curr.next == null) {
            curr.next = pre;
            return curr;
        }

        ListNode next = curr.next;
        curr.next = pre;
        return reverse(curr, next);
    }
}
