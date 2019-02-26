import java.util.ArrayList;
import java.util.List;

public class Utils<E> {
    public ListNode linkedListGiveValue(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode a = head;

        for (int i = 1; i < nums.length; i++) {
            a.next = new ListNode(nums[i]);
            a = a.next;
        }

        return head;
    }

    public List<E> listGiveValue(E[] nums) {
        List<E> list = new ArrayList<>();
        for (E num : nums) {
            list.add(num);
        }

        return list;
    }

    public void printList(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }

        System.out.println();
    }

    public void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print("-->");
            node = node.next;
        }

        System.out.println();
    }

    public void printArray(E[] nums) {
        for (E num : nums) {
            System.out.print(num + "\t");
        }

        System.out.println();
    }
}
