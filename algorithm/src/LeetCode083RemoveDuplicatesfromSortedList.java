/*
Example 1:

Input: 1->1->2
Output: 1->2

Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode beforeNode = head;
        ListNode afterNode = head.next;

        while (afterNode != null) {
            if (afterNode.val == beforeNode.val) {
                afterNode = afterNode.next;
                if (afterNode == null) {
                    beforeNode.next = null;
                    break;
                }
            } else {
                beforeNode.next = afterNode;
                beforeNode = afterNode;
                afterNode = afterNode.next;
            }
        }

        return head;
    }
}
