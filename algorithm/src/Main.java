import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

	public static class NInteger implements NestedInteger {

		private Integer val;
		private List<NestedInteger> list;

		public NInteger(Integer val, List<NestedInteger> list) {
			this.val = val;
			this.list = list;
		}

		@Override
		public boolean isInteger() {
			return this.val != null;
		}

		@Override
		public Integer getInteger() {
			if (isInteger()) return this.val;
			else return null;
		}

		@Override
		public List<NestedInteger> getList() {
			if (!isInteger()) return this.list;
			else return null;
		}
	}

    public static void main(String[] args) {
	    List<NestedInteger> list = new ArrayList<>();
	    List<NestedInteger> a = new ArrayList<>();
	    list.add(new NInteger(null, a));
	    list.add(new NInteger(2, null));
	    List<NestedInteger> b = new ArrayList<>(Arrays.asList(new NInteger(1, null), new NInteger(1, null)));
	    list.add(new NInteger(null, b));

	    LeetCode341FlattenNestedListIterator i = new LeetCode341FlattenNestedListIterator(list);
	    while (i.hasNext()) {
		    System.out.println(i.next());
	    }
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
