/*
Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:

Input: 1->1->1->2->3
Output: 2->3
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode082RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head; // 只有一个结点的情况

        // 先把开头的重复元素去除
        while (head.val == head.next.val) {
            ListNode newHead = head;
            while (newHead.val == newHead.next.val) {
                newHead = newHead.next;
                if (newHead.next == null) return null;  // 保证 newHead.next 不为空
            }
            head = newHead.next;
            if (head.next == null) return head; // 保证 head.next 不为空
        }

        if (head.next == null || head.next.next == null) return head; // 如果这个时候只有一个结点

        ListNode beforeNode = head;
        ListNode afterNode = head.next;
        boolean flag = false;       // 表示是否连续

        while (afterNode.next != null) {
            if (afterNode.val == afterNode.next.val) {
                flag = true;
                afterNode = afterNode.next;
                // 如果 afterNode.next 是 null，证明最后几个数都是一致的
                if (afterNode.next == null) {
                    beforeNode.next = null;
                    break;
                }
            } else {
                if (!flag) {    // 不连续的话直接往后走就行了
                    beforeNode = beforeNode.next;
                    afterNode = afterNode.next;
                } else {
                    beforeNode.next = afterNode.next;
                    afterNode = afterNode.next;
                    flag = false;
                }
            }
        }

        return head;
    }
}
