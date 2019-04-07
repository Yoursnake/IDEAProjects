/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
public class LeetCode117PopulatingNextRightPointersinEachNodeII {
    // 法一：非递归做法
    public Node connect(Node root) {
        if (root == null) return null;
        Node pre = root;
        Node curr;

        while (pre.left != null) {
            curr = pre;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            pre = pre.left;
        }
        return root;
    }

//    // 法二：递归做法
//    public Node connect(Node root) {
//        if (root == null) return null;
//
//        if (root.left != null) {
//            root.left.next = root.right;
//            if (root.next != null)
//                root.right.next = root.next.left;
//        }
//
//        connect(root.left);
//        connect(root.right);
//        return root;
//    }

//    // 法三：广度优先遍历（最慢）
//    public Node connect(Node root) {
//        if (root == null) return null;
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        int currNum = 1;
//
//        while (!queue.isEmpty()) {
//            int nextNum = 0;
//            Node lastNode = queue.poll();
//            nextNum = addQueue(queue, lastNode, nextNum);
//
//            for (int i = 1; i < currNum; i++) {
//                Node currNode = queue.poll();
//                lastNode.next = currNode;
//                lastNode = currNode;
//
//                nextNum = addQueue(queue, currNode, nextNum);
//            }
//
//            currNum = nextNum;
//        }
//
//        return root;
//    }
//
//    // 判断 node 是否有子节点，若有则加入 queue 中，并改变 nextNum
//    private int addQueue(Queue<Node> queue, Node node, int nextNum) {
//        if (node.left != null) {
//            queue.offer(node.left);
//            nextNum++;
//        }
//        if (node.right != null) {
//            queue.offer(node.right);
//            nextNum++;
//        }
//        return nextNum;
//    }
}
