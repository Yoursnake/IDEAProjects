/*
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */

public class LeetCode21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode point = result;

        // 如果是空的就不需要排序了
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        while (true) {  // 当两个list都有数时，每个循环处理一个数
            if (l1.val < l2.val) {
                point.val = l1.val;
                l1 = l1.next;
            } else {
                point.val = l2.val;
                l2 = l2.next;
            }

            // 建立新节点必须在l1和l2都还有数的前提下
            if (l1 != null || l2 != null) {
                ListNode temp = new ListNode(-1);
                point.next = temp;
                point = point.next;
            }

            // l1空时，处理l2剩下的数
            if (l1 == null) {
                while (l2 != null) {
                    point.val = l2.val;
                    l2 = l2.next;
                    // 有数才多加结点
                    if (l2 != null) {
                        ListNode temp = new ListNode(-1);
                        point.next = temp;
                        point = point.next;
                    }
                }
                break;
            }

            // l2空时，处理l1剩下的数
            if (l2 == null) {
                while (l1 != null) {
                    point.val = l1.val;
                    l1 = l1.next;
                    // 有数才多加结点
                    if (l1 != null) {
                        ListNode temp = new ListNode(-1);
                        point.next = temp;
                        point = point.next;
                    }
                }
                break;
            }
        }

        return result;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

