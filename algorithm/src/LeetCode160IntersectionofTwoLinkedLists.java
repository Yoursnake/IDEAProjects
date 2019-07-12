/*
Write a program to find the node at which the intersection of two
singly linked lists begins.

For example, the following two linked lists:

begin to intersect at node c1.

Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5],
skipA = 2, skipB = 3
Output: Reference of the node with value = 8

Input Explanation: The intersected node's value is 8 (note that
this must not be 0 if the two lists intersect). From the head of A,
it reads as [4,1,8,4,5]. From the head of B, it reads as
[5,0,1,8,4,5]. There are 2 nodes before the intersected node in A;
There are 3 nodes before the intersected node in B.

Example 2:

Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2

Input Explanation: The intersected node's value is 2 (note that this must not be 0
if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the
head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A;
There are 1 node before the intersected node in B.


Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null

Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B,
it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LeetCode160IntersectionofTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 一个为空就不可能相交
        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;
        int countA = 1;     // 计算 A 一共多少节点
        int countB = 1;     // 计算 B 一共多少节点
        int diff;

        // A B 都走到最后一个节点
        while (ptrA.next != null) {
            countA++;
            ptrA = ptrA.next;
        }

        while (ptrB.next != null) {
            countB++;
            ptrB = ptrB.next;
        }

        if (ptrA != ptrB) return null;  // 如果不等就无交叉

        ptrA = headA;
        ptrB = headB;
        diff = countA - countB; // 计算两者相差数量
        // 长的那链先走 |diff| 步
        if (diff < 0) for (int i = 0; i < -diff; i++) ptrB = ptrB.next;
        else if (diff > 0) for (int i = 0; i < diff; i++) ptrA = ptrA.next;

        // 然后两链一起走，直到走到的节点相等
        while (ptrA != ptrB) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return ptrA;
    }
}
