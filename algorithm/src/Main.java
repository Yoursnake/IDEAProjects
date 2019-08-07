/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        int result = new LeetCode190ReverseBits().reverseBits(n);
        System.out.println(result);
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
