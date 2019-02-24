import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static ListNode linkedListGiveValue(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode a = head;

        for (int i = 1; i < nums.length; i++) {
            a.next = new ListNode(nums[i]);
            a = a.next;
        }

        return head;
    }

    public static List<Integer> listGiveValue(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return list;
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }

        System.out.println();
    }

    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print("-->");
            node = node.next;
        }

        System.out.println();
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + "\t");
        }

        System.out.println();
    }
}
