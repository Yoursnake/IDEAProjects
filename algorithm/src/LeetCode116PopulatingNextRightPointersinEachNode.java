import java.util.LinkedList;
import java.util.Queue;

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
public class LeetCode116PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int currNum = 1;

        while (!queue.isEmpty()) {
            int nextNum = 0;
            Node lastNode = queue.poll();
            nextNum = addQueue(queue, lastNode, nextNum);

            for (int i = 1; i < currNum; i++) {
                Node currNode = queue.poll();
                lastNode.next = currNode;
                lastNode = currNode;

                nextNum = addQueue(queue, currNode, nextNum);
            }

            currNum = nextNum;
        }

        return root;
    }

    // 判断 node 是否有子节点，若有则加入 queue 中，并改变 nextNum
    private int addQueue(Queue<Node> queue, Node node, int nextNum) {
        if (node.left != null) {
            queue.offer(node.left);
            nextNum++;
        }
        if (node.right != null) {
            queue.offer(node.right);
            nextNum++;
        }
        return nextNum;
    }
}
