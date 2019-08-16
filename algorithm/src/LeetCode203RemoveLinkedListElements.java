/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode203RemoveLinkedListElements {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode beforeHead = new ListNode(-1);
        ListNode pre = beforeHead;
        ListNode curr = head;
        pre.next = head;

        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                curr = curr.next;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
        }

        return beforeHead.next;
    }
}
