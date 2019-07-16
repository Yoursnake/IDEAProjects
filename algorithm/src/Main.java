/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1.0.0";

        int result = new LeetCode165CompareVersionNumbers().compareVersion(version1, version2);
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
