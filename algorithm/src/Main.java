/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        boolean result = new LeetCode205IsomorphicStrings().isIsomorphic(s, t);
        System.out.println(result);
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
