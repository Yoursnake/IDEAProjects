/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        LeetCode203RemoveLinkedListElements.ListNode head = linkedListGiveValue(nums);
        LeetCode203RemoveLinkedListElements.ListNode result = new LeetCode203RemoveLinkedListElements().removeElements(head, 6);
//        System.out.println(result);
        printLinkedList(result);
    }

    public static void printLinkedList(LeetCode203RemoveLinkedListElements.ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print("-->");
            node = node.next;
        }

        System.out.println();
    }

    public static LeetCode203RemoveLinkedListElements.ListNode linkedListGiveValue(int[] nums) {
        LeetCode203RemoveLinkedListElements.ListNode head = new LeetCode203RemoveLinkedListElements.ListNode(nums[0]);
        LeetCode203RemoveLinkedListElements.ListNode a = head;

        for (int i = 1; i < nums.length; i++) {
            a.next = new LeetCode203RemoveLinkedListElements.ListNode(nums[i]);
            a = a.next;
        }

        return head;
    }
}
