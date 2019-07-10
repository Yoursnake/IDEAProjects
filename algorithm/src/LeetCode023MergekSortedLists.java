import java.util.ArrayList;
import java.util.Arrays;

/*
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */

public class LeetCode23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> arrayLists = new ArrayList(Arrays.asList(lists));

        ListNode result = new ListNode(-1); // 头指针
        ListNode point = result;            // 用来标记当前结点

        while (arrayLists.contains(null)) {
            arrayLists.remove(null);
        }

        if (arrayLists.isEmpty()) {
            return null;
        } else if (arrayLists.size() == 1) {
            return arrayLists.get(0);
        }

        while (true) {
            int value = findMin(arrayLists);    // 找到最小值，并更新arrayLists
            point.val = value;

            if (!arrayLists.isEmpty()) {        // 如果非空，表示还有数据需要排序
                ListNode temp = new ListNode(-1);
                point.next = temp;
                point = point.next;
            } else {
                break;
            }
        }

        return result;
    }

    private int findMin(ArrayList<ListNode> arrayLists) {
        ListNode minNode = arrayLists.get(0);
        int min = minNode.val;
        int index = 0;

        for (int i = 1; i < arrayLists.size(); i++) {
            ListNode curNode = arrayLists.get(i);
            int curVal = curNode.val;
            // 找最小值并记录索引
            if (curVal < min) {
                min = curVal;
                minNode = curNode;
                index = i;
            }
        }

        // ArrayList 不能直接更新结点，所以需要先删除再添加
        arrayLists.remove(index);   // 把原来的删去
        minNode = minNode.next;
        arrayLists.add(minNode);    // 把移动后的结点加入
        if (minNode == null) {
            arrayLists.remove(minNode); // 如果结点到了最后就没必要更新了，删去
        }

        return min;
    }


}


