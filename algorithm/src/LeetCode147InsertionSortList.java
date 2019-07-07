/*
Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black)
initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and
inserted in-place into the sorted list


Algorithm of Insertion Sort:

1. Insertion sort iterates, consuming one input element each repetition, and
growing a sorted output list.
2. At each iteration, insertion sort removes one element from the input data,
finds the location it belongs within the sorted list, and inserts it there.
3. It repeats until no input elements remain.

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
public class LeetCode147InsertionSortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode sortHead = head;       // 记录已排序的头指针
        ListNode sortTail = head;       // 记录已排序的尾指针
        ListNode curr1 = sortTail.next; // 当前要排序的节点

        while (curr1 != null) {
            sortTail.next = curr1.next;      // 删除 curr1

            // 排除开头结尾两种情况，只有这两种情况 sortHead 和 sortTail 会改变
            if (curr1.val <= sortHead.val) {
                curr1.next = sortHead;
                sortHead = curr1;
            } else if (curr1.val > sortTail.val) {
                sortTail.next = curr1;
                sortTail = curr1;
            } else {
                ListNode curr2 = sortHead;  // 与要排序的 curr1 进行比较大小的节点
                while (curr2 != sortTail) {
                    if (curr2.val < curr1.val && curr1.val <= curr2.next.val) {
                        curr1.next = curr2.next;
                        curr2.next = curr1;
                        break;
                    }
                    curr2 = curr2.next;
                }
            }

            curr1 = sortTail.next;
        }

        return sortHead;
    }
}
