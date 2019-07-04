/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {

        LeetCode143ReorderList.ListNode node = new LeetCode143ReorderList.ListNode(1);
        node.next = new LeetCode143ReorderList.ListNode(2);
        node.next.next = new LeetCode143ReorderList.ListNode(3);
        node.next.next.next = new LeetCode143ReorderList.ListNode(4);
//        node.next.next.next.next = new LeetCode143ReorderList.ListNode(5);

        new LeetCode143ReorderList().reorderList(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
