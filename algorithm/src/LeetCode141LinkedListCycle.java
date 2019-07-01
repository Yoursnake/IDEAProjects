/*
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos
which represents the position (0-indexed) in the linked list where tail
connects to. If pos is -1, then there is no cycle in the linked list.


Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects
to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects
to the first node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LeetCode141LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    // set 13.28%  space : O(n)
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) return false;
//
//        HashSet<ListNode> set = new HashSet<>();
//        set.add(head);
//
//        do {
//            head = head.next;
//            if (set.contains(head)) return true;
//            else set.add(head);
//        } while (head != null);
//
//        return false;
//    }

    // 追逐，慢的一次走一步，快的一次走两步，追到两个相等则有环
    // 100.00% space : O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            // 只要 fast 当前是 null，或下一个是 null 就表明一定不是环（尽头是 null）
            if (fast == null && fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
