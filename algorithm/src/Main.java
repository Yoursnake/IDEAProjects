/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        LeetCode148SortList.ListNode head = new LeetCode148SortList.ListNode(-1);
        head.next = new LeetCode148SortList.ListNode(5);
        head.next.next = new LeetCode148SortList.ListNode(3);
        head.next.next.next = new LeetCode148SortList.ListNode(4);
        head.next.next.next.next = new LeetCode148SortList.ListNode(0);

        printLinkedList(head);
        head = new LeetCode148SortList().sortList(head);
        printLinkedList(head);
    }

    public static void printLinkedList(LeetCode148SortList.ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print("-->");
            node = node.next;
        }

        System.out.println();
    }
}
