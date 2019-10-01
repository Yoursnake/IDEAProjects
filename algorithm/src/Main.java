/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
	    LeetCode295FindMedianfromDataStream ds = new LeetCode295FindMedianfromDataStream();
	    ds.addNum(1);
	    System.out.println(ds.findMedian());
		ds.addNum(2);
        System.out.println(ds.findMedian());
	    ds.addNum(3);
	    System.out.println(ds.findMedian());
//	    ds.addNum(-4);
//	    System.out.println(ds.findMedian());
//	    ds.addNum(-5);
//	    System.out.println(ds.findMedian());
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
