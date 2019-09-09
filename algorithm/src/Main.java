/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
        LeetCode211AddandSearchWord obj = new LeetCode211AddandSearchWord();
        obj.addWord("at");
        obj.addWord("and");
        obj.addWord("an");
        obj.addWord("a");

        System.out.println(obj.search(".at"));
        obj.addWord("bat");
        System.out.println(obj.search(".at"));
//        System.out.println(obj.search(".ad"));
//        System.out.println(obj.search("b.."));
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
