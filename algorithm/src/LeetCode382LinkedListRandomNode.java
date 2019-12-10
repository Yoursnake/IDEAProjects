/*
Given a singly linked list, return a random node's value from the linked list. 
Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? 
Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
*/

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// // 10ms 98%
// // 允许求出链表长度的情况下
// public class LeetCode382LinkedListRandomNode {
// 	private class ListNode {
// 	    int val;
// 	    ListNode next;
// 	    ListNode(int x) { val = x; }
// 	}

// 	private int size;
// 	private ListNode head;
// 	private Random random;

// 	/** @param head The linked list's head.
//         Note that the head is guaranteed to be not null, so it contains at least one node. */
//     public LeetCode382LinkedListRandomNode(ListNode head) {
//         this.head = head;
//         random = new Random();

//         size = 0;
//         while (head != null) {
//         	size++;
//         	head = head.next;
//         }
//     }
    
//     /** Returns a random node's value. */
//     public int getRandom() {
//         int idx = random.nextInt(size);
//         ListNode point = head;
//         for (int i = 0; i < idx; i++) {
//         	point = point.next;
//         }

//         return point.val;
//     }
// }

// Reservior Sample: 13ms 86.9%
// follow up: 不允许求出链表长度的情况下
// 每个节点被选中的概率为 (1/i)*(1-1/(i+1))*(1-1/(i+2))*...*(1/n) = 1/n，不考虑前面的节点，只考虑该节点该选中且不被后面的节点替换
// 参考：https://leetcode.com/problems/linked-list-random-node/discuss/85662/Java-Solution-with-cases-explain 和 https://www.youtube.com/watch?v=A1iwzSew5QY
public class LeetCode382LinkedListRandomNode {
	private class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	private ListNode head;
	private Random random;

	/** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LeetCode382LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
    	ListNode point = head;
    	int cnt = 0;
    	int res = -1;

        while (point != null) {
        	if (random.nextInt(cnt + 1) == cnt) res = point.val;
        	point = point.next;
        	cnt++;
        }

        return res;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */