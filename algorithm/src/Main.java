/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
        int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;

        int res = new LeetCode223RectangleArea().computeArea(A, B, C, D, E, F, G, H);
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
