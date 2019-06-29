/*
A linked list is given such that each node contains an additional random
pointer which could point to any node in the list or null.

Return a deep copy of the list.



Example 1:



Input:
{"$id":"1","next":{"$id":"2","next":null,"random":
{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer
points to itself.
 */

import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
public class LeetCode138CopyListwithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();  // 存放 <原始节点, 拷贝节点>
        Node copy = new Node();
        copy.val = head.val;
        map.put(head, copy);    // 没创建一个节点就放入map

        Node pointHead = head;  // 指向原始节点的指针
        Node pointCopy = copy;  // 指向拷贝节点的指针

        do {
            Node originNext = pointHead.next;

            if (originNext == null) {   // 排除 null 的可能性
                pointCopy.next = null;
            } else {
                // 现在 map 中找，如果找不到就新建一个节点，并放入 map 中
                if (map.containsKey(originNext)) {
                    pointCopy.next = map.get(originNext);
                } else {
                    Node copyNext = new Node();
                    copyNext.val = originNext.val;
                    map.put(originNext, copyNext);
                    pointCopy.next = copyNext;
                }
            }

            Node originRandom = pointHead.random;

            if (originRandom == null) {     // 排除 null 的可能性
                pointCopy.random = null;
            } else {
                // 现在 map 中找，如果找不到就新建一个节点，并放入 map 中
                if (map.containsKey(originRandom)) {
                    pointCopy.random = map.get(originRandom);
                } else {
                    Node copyRandom = new Node();
                    copyRandom.val = originRandom.val;
                    map.put(originRandom, copyRandom);
                    pointCopy.random = copyRandom;
                }
            }

            pointHead = pointHead.next;
            pointCopy = pointCopy.next;
        } while (pointHead != null);

        return copy;
    }
}
