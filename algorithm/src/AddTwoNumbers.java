import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */
public class AddTwoNumbers {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static void addNode(ListNode l, int x){ //为链表l 添加节点s 的方法
        ListNode s = new ListNode(x); //用于添加的节点
        ListNode p = l; //用于查询的指针
        while (p.next != null) {
            p = p.next;
        }
        p.next = s;
    }



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode l3 = new ListNode(-1);
        ListNode r = l3;
        int num1, num2, num3;
        boolean isUp = false;   //表示是否进位
        while (p != null || q != null){
            if (p != null) {    // 第一条链的数
                num1 = p.val;
                p = p.next;
            } else {
                num1 = 0;
            }

            if (q != null) {    // 第二条链的数
                num2 = q.val;
                q = q.next;
            } else {
                num2 = 0;
            }

            num3 = num1 + num2;
            if (isUp){      // 如果需要需要进位为是则第三条链的数加一，并把进位变为否
                num3 = num3 + 1;
                isUp = false;
            }

            r.val = num3%10;


            if (num3 >= 10) {
                isUp = true;
            }

            if (p != null || q != null){       //如果p q有一个不为空，则生成一个尾节点
                r.next = new ListNode(-1);
            }
            if (r.next != null) {
                r = r.next; //尾节点不为空时，r向后移位，即成为尾节点
            }
        }
        if (isUp){
            r.next = new ListNode(1);
        }
        return l3;
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(0); //这个是头结点
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = l3;
        int temp = 0;

        while (p != null || q != null){
            int x = p!=null?p.val:0;
            int y = q!=null?q.val:0;
            int sum = x + y + temp;

            temp = sum/10;

            r.next = new ListNode(sum%10);
            r = r.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (temp > 0){
            r.next = new ListNode(temp);
        }
        return l3.next;
    }

    /*由于int型有效位只有9位，当大数相加时，会失真*/
    //    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int num1 = 0, num2 = 0;
//        int num3 = 0;
//        int count1 = 0;
//        int count2 = 0;
//        int temp1, temp2;
//        ListNode l3 = null, p = null;
//
//        while (l1 != null){
//            temp1 = l1.val;
//            for (int i = 0; i < count1; i++) {
//                temp1 = temp1 * 10;
//            }
//            num1 += temp1;
//            count1++;
//            l1 = l1.next;
//        }
//        while (l2 != null){
//            temp2 = l2.val;
//            for (int i = 0; i < count2; i++) {
//                temp2 = temp2 * 10;
//            }
//            num2 += temp2;
//            count2++;
//            l2 = l2.next;
//        }
//        num3 = (int)(num1 + num2);
//
//        l3 = new ListNode(num3%10);
//        p = l3;
//        num3 = num3/10;
//        while (num3 != 0){
//            ListNode node = new ListNode(num3%10);
//            num3 = num3/10;
//            p.next = node;
//            p = p.next;
//        }
//        return l3;
//    }
}
