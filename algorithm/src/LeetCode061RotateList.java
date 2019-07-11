/*
Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class LeetCode061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode temp = head;
        int listLen = 1;
        while (temp.next != null) {
            listLen++;
            temp = temp.next;
        }

        temp.next = head;   // 这个时候 temp 在尾巴上，接到头上围成一个圈

        int targetTailIndex = k - 1 - k % listLen;

        // 把 temp 转移到将要截断的结点处
        temp = head;
        for (int i = 0; i < targetTailIndex; i++) {
            temp = temp.next;
        }

        head = temp.next;   // 保存 head 指针
        temp.next = null;   // 截断

        return head;
    }
}
