/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
	    LeetCode297SerializeandDeserializeBinaryTree t = new LeetCode297SerializeandDeserializeBinaryTree();
	    LeetCode297SerializeandDeserializeBinaryTree.TreeNode a = t.new TreeNode(1);
	    a.left = t.new TreeNode(2);
	    a.right = t.new TreeNode(3);
	    a.right.left = t.new TreeNode(4);
	    a.right.right = t.new TreeNode(5);

		String s = t.serialize(a);
	    System.out.println(s);

	    LeetCode297SerializeandDeserializeBinaryTree.TreeNode x = t.deserialize(s);

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
