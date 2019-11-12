/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
//	    String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
	    String preorder = "1,#,#,#,#";

	    boolean res = new LeetCode331VerifyPreorderSerializationofaBinaryTree().isValidSerialization(preorder);

	    System.out.println(res);

//	    int[] nums = {4, 0, 9, 9, 0, 5, 5, 4, 7};
//	    int k = 4;
//	    int[] res = new LeetCode321CreateMaximumNumber().findMaxNumber(nums, k);

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
