/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode92ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null || m == n) return head;

        // 加一个头指针（关键）
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        head = newHead;

        ListNode mBefore = head;        // 该指针最终停留在 m-1 个结点
        ListNode nAfter = head.next;    // 该指针最终停留在 n+1 个结点
        int mBeforeIndex = 0;
        int nAfterIndex = 1;

        // 最后 mBeforeIndex == m - 1，nAfterIndex == m
        while (mBeforeIndex <= m - 2) {
            mBefore = mBefore.next;
            nAfter = nAfter.next;
            mBeforeIndex++; nAfterIndex++;
        }


        ListNode mNode = mBefore.next;  // 第 m 个结点，最终该结点指向第 n+1 个结点
        ListNode goPoint = nAfter.next; // 从这个指针指向前一个指针完成反转
        ListNode toPoint = nAfter;
        nAfter = nAfter.next.next;      // 该指针始终指向 goPoint 下一个节点
        nAfterIndex = nAfterIndex + 2;

        while (true) {
            goPoint.next = toPoint;

            if (nAfterIndex - 1 == n) { // 如果到达 n+1 个结点
                mBefore.next = goPoint;
                mNode.next = nAfter;
                break;
            } else {
                // 每个指针都指向后一个结点
                toPoint = goPoint;
                goPoint = nAfter;
                nAfter = nAfter.next;
                nAfterIndex++;
            }
        }

        return head.next;   // 去头
    }
}
