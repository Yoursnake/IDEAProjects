/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LeetCode086PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head; // 一个元素

        // 给链表加一个头
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        head = newHead;

        ListNode beforeNode = head;
        ListNode afterNode = head.next;

        // 找到大于等于 x 的结点为止
        while (afterNode.val < x) {
            beforeNode = beforeNode.next;
            afterNode = afterNode.next;
            if (afterNode == null) return head.next;
        }

        while (afterNode.next != null) {
            if (afterNode.next.val < x) {
                ListNode addNode = new ListNode(afterNode.next.val);
                afterNode.next = afterNode.next.next;   // 删去小于 x 的结点
                addNode.next = beforeNode.next;         // 加入结点
                beforeNode.next = addNode;
                beforeNode = beforeNode.next;

                if (afterNode.next == null) break;
            } else {
                afterNode = afterNode.next;
            }
        }

        head = head.next;   // 把链表头去掉
        return head;
    }
}
