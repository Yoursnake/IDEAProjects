/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode148SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 本质是归并排序 97.53%
    public ListNode sortList(ListNode head) {
        // 如果没有元素或只有一个元素不需要排序
        if (head == null || head.next == null) return head;

        // 如果有两个元素
        if (head.next.next == null) {
            // 如果前面的值比后面的大，交换两节点位置
            if (head.next.val < head.val) {
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = head;
                return temp;
            } else {
                return head;
            }
        }

        // 用快慢指针找到 List 中点位置（slow 最终位置）
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;       // 将 List 断成两个 List
        first = sortList(first);    // 分别排序
        second = sortList(second);  // 分别排序

        ListNode result = mergeList(first, second);
        return result;
    }

    // 将两个有序 List 拍成一个 List
    private ListNode mergeList(ListNode first, ListNode second) {
        ListNode ptr1 = first;
        ListNode ptr2 = second;
        ListNode resHead = new ListNode(-1);    // 建立一个头指针（无意义）
        ListNode resTail = resHead;                // 尾指针
        // 和归并排序思想一致
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                resTail.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                resTail.next = ptr2;
                ptr2 = ptr2.next;
            }
            resTail = resTail.next;
        }

        // 如果 List1 或 List2 还有剩下的继续接到 resTail 上
        if (ptr1 != null) resTail.next = ptr1;
        if (ptr2 != null) resTail.next = ptr2;

        return resHead.next;    // 去掉头指针
    }
}
