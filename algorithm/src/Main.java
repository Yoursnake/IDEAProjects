/**
 * Created by shengliyi on 2017/3/4.
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String num = "105";
		int target = 5;

	    List<String> res = new LeetCode282ExpressionAddOperators().addOperators(num, target);
        System.out.println(res);

    }

    public static void printLinkedList(LeetCode206ReverseLinkedList.ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print("-->");
            node = node.next;
        }

        System.out.println();
    }

    public static LeetCode206ReverseLinkedList.ListNode linkedListGiveValue(int[] nums) {
        LeetCode206ReverseLinkedList.ListNode head = new LeetCode206ReverseLinkedList.ListNode(nums[0]);
        LeetCode206ReverseLinkedList.ListNode a = head;

        for (int i = 1; i < nums.length; i++) {
            a.next = new LeetCode206ReverseLinkedList.ListNode(nums[i]);
            a = a.next;
        }

        return head;
    }
}
