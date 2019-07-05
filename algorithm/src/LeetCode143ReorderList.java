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

//    // 9%  wait improve
//    public void reorderList(ListNode head) {
//        if (head == null) return;
//
//        HashMap<Integer, ListNode> map = new HashMap<>();
//        ListNode curr = head;
//        int count = 0;
//
//        // 先遍历一遍，计算总长存放在 count，并把每个 <index, ListNode> 存储在 map 中
//        while (curr != null) {
//            map.put(count, curr);
//            count = count + 1;
//            curr = curr.next;
//        }
//
//        curr = head;    // 变回开头
//        for (int i = 0; i < Math.round(count / 2.0) - 1; i++) {
//            ListNode before = curr; // 前面的节点
//            curr = curr.next;       // before 后面一个节点
//
//            ListNode after = map.get(count - 1 - i);    // 找到和 before 对称的节点
//            before.next = after;
//            after.next = curr;
//        }
//
//        if (count % 2 == 0) curr.next.next = null;  // 偶数的话 curr 后两个节点改 null
//        else curr.next = null;                      // 奇数的话 curr 后一个节点改 null
//    }

    // 100%
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        // 找终点，最终 slow 停止的位置就是终点位置 n/2 (向上取整)
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;      // 第一段 List 头指针
        ListNode second = slow.next;// 第二段 List 头指针
        slow.next = null;           // 将 List 分成两段

        second = reverse(second);
        mergeList(first, second);
    }

    // 将 List 反转，返回头指针
    private ListNode reverse(ListNode second) {
        ListNode preNode = null;
        ListNode currNode = null;
        ListNode nextNode = second;

        while (nextNode != null) {
            currNode = nextNode;
            nextNode = nextNode.next;
            currNode.next = preNode;
            preNode = currNode;
        }

        return currNode;
    }

    // 将两个 List 串起来
    private void mergeList(ListNode first, ListNode second) {
        ListNode curr1 = first;     // 表示当前 first 位置
        ListNode curr2 = second;
        ListNode next1 = first;     // 一直表示原始 first 的 next
        ListNode next2 = second;    // 一直表示原始 second 的 next

        while (next2 != null) {
            next1 = next1.next;
            curr1.next = curr2;
            next2 = next2.next;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
    }
}
