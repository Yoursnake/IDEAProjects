/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
    public static void main(String[] args) {
//        int[] nums = {3,2,3,1,2,4,5,5,6};
//        int k = 4;
//        int[] nums = {-1, 2, 0};
//        int k = 1;

        String s = "aabba";

//        StringBuilder sb = new StringBuilder(s);
//        System.out.println(sb.append(sb.reverse()).toString());

        String res = new LeetCode214ShortestPalindrome().shortestPalindrome(s);
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
