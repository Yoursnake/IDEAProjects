/**
 * Created by shengliyi on 2017/4/6.
 */

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



public class LeetCode19RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        int num = count - n;
        p = head;
        for (int i = num; i > 0; i--) {
            p = p.next;
        }
        if (num != 0) { // num != 0 表示移除的元素不是头指针
            p.next = p.next.next;
        } else {
            head = p.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}