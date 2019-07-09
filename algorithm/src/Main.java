/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        String s = "a good   example";

        String result = new LeetCode151ReverseWordsinaString().reverseWords(s);
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
