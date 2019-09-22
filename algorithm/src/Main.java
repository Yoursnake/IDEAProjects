/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
        LeetCode234PalindromeLinkedList.ListNode head = new LeetCode234PalindromeLinkedList.ListNode(1);
        head.next = new LeetCode234PalindromeLinkedList.ListNode(2);
        head.next.next = new LeetCode234PalindromeLinkedList.ListNode(2);
        head.next.next.next = new LeetCode234PalindromeLinkedList.ListNode(1);
        boolean res = new LeetCode234PalindromeLinkedList().isPalindrome(head);
        System.out.println(res);


//        Integer[] arr = {5, 2, 4, 1, 2, 5, 6, 2, 10};
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
//        System.out.println(maxHeap.findMax());
//        maxHeap.printHeap();
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
