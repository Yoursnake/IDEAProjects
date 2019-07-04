/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only
nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode143ReorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 9%  wait improve
    public void reorderList(ListNode head) {
        if (head == null) return;

        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode curr = head;
        int count = 0;

        // 先遍历一遍，计算总长存放在 count，并把每个 <index, ListNode> 存储在 map 中
        while (curr != null) {
            map.put(count, curr);
            count = count + 1;
            curr = curr.next;
        }

        curr = head;    // 变回开头
        for (int i = 0; i < Math.round(count / 2.0) - 1; i++) {
            ListNode before = curr; // 前面的节点
            curr = curr.next;       // before 后面一个节点

            ListNode after = map.get(count - 1 - i);    // 找到和 before 对称的节点
            before.next = after;
            after.next = curr;
        }

        if (count % 2 == 0) curr.next.next = null;  // 偶数的话 curr 后两个节点改 null
        else curr.next = null;                      // 奇数的话 curr 后一个节点改 null
    }
}
