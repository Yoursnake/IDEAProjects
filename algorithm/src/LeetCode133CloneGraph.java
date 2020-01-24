/*
Given a reference of a node in a connected undirected graph,
return a deep copy (clone) of the graph. Each node in the graph
contains a val (int) and a list (List[Node]) of its neighbors.

Example:


Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},
{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":
[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},
{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.


Note:

1. The number of nodes will be between 1 and 100.
2. The undirected graph is a simple graph, which means no repeated
   edges and no self-loops in the graph.
3. Since the graph is undirected, if node p has node q as neighbor,
   then node q must have node p as neighbor too.
4. You must return the copy of the given node as a reference to
   the cloned graph.
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
public class LeetCode133CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // public Node cloneGraph(Node node) {
    //     if (node == null) return null;

    //     HashMap<Integer, Node> finished = new HashMap<>();  // 表示某个值的点是否创建
    //     Node curr = new Node();
    //     curr.val = node.val;

    //     finished.put(curr.val, curr);
    //     DFS(curr, node.neighbors, finished);
    //     return curr;
    // }

    // private void DFS(Node curr, List<Node> neighbors, HashMap<Integer, Node> finished) {
    //     List<Node> newNeighbors = new ArrayList<>();
    //     for (Node neighbor : neighbors) {
    //         int val = neighbor.val;

    //         // 如果点已经创建过就不重复创建，从 map 中直接拿
    //         // 当所有元素创建完毕将不再递归
    //         if (finished.containsKey(val)) {
    //             newNeighbors.add(finished.get(val));
    //         } else {
    //             Node temp = new Node();
    //             temp.val = val;
    //             newNeighbors.add(temp);
    //             finished.put(val, temp);    // 将创建的点加入 map
    //             DFS(temp, neighbor.neighbors, finished);
    //         }
    //     }

    //     curr.neighbors = newNeighbors;      // 将完成的你 neighbors 加入节点
    // }

    // DFS: 54ms 5.3%
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    
    private Node dfs(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        
        Node curr = new Node(node.val);
        map.put(node.val, curr);
        
        for (Node neighbor : node.neighbors) {
            curr.neighbors.add(dfs(neighbor, map));
        }
        
        return curr;
    }
}