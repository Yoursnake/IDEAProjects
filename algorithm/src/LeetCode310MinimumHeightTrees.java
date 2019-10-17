/*
For an undirected graph with tree characteristics, we can choose any 
node as the root. The result graph is then a rooted tree. Among all 
possible rooted trees, those with minimum height are called minimum 
height trees (MHTs). Given such a graph, write a function to find all 
the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will 
be given the number n and a list of undirected edges (each edge is a 
pair of labels).

You can assume that no duplicate edges will appear in edges. Since all 
edges are undirected, [0, 1] is the same as [1, 0] and thus will not 
appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]

Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

Output: [3, 4]

Note:

According to the definition of tree on Wikipedia: “a tree is an 
undirected graph in which any two vertices are connected by exactly 
one path. In other words, any connected graph without simple cycles 
is a tree.”
The height of a rooted tree is the number of edges on the longest 
downward path between the root and a leaf.
*/

import java.util.*;

// // DFS: 15% 45ms
// public class LeetCode310MinimumHeightTrees {

// 	// 用于使用 key-pair 作为 HashMap 的 key，需要重写 equals 和 hashCode 函数
// 	private class Key {
// 		private final int x;
// 		private final int y;

// 		Key(int x, int y) {
// 			this.x = x;
// 			this.y = y;
// 		}

// 		public boolean equals(Object o) {
// 			if (this == o) return true;
// 			if (!(o instanceof Key)) return false;
// 			Key key = (Key) o;
// 			return this.x == key.x && this.y == key.y;
// 		}

// 		public int hashCode() {
// 			int res = x;
// 			res = 31 * res + y;
// 			return res;
// 		}
// 	}

// 	// 使用邻接表存储图
// 	private class Graph {
// 		List<Integer>[] nodes;

// 		Graph(int nodeNum) {
// 			this.nodes = new List[nodeNum];

// 			for (int i = 0; i < nodeNum; i++) {
// 				this.nodes[i] = new ArrayList<>();
// 			}
// 		}

// 		void add(int i, int j) {
// 			nodes[i].add(j);
// 		}
// 	}

// 	// DFS: 15% 45ms
// 	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
// 		if (n == 0) return Collections.EMPTY_LIST;
// 		if (n == 1) return new ArrayList<>(Arrays.asList(0));

// 		Graph graph = new Graph(n);
// 		List<Integer> res = new ArrayList<>();
// 		Map<Key, Integer> map = new HashMap<>();

// 		for (int i = 0; i < edges.length; i++) {
// 			graph.add(edges[i][0], edges[i][1]);
// 			graph.add(edges[i][1], edges[i][0]);
// 		}

// 		int min = Integer.MAX_VALUE;
// 		int[] heights = new int[n];

// 		for (int i = 0; i < n; i++) {
// 			int h = getHeight(graph, -1, i, map);
// 			heights[i] = h;
// 			min = Math.min(h, min);
// 		}

// 		for (int i = 0; i < n; i++) {
// 			if (heights[i] == min) res.add(i);
// 		}

// 		return res;
// 	}

// 	// DFS: 得到点 curr 的高度（从 last 到 curr）
// 	private int getHeight(Graph graph, int last, int curr, Map<Key, Integer> map) {
// 		if (graph.nodes[curr].size() == 1 && graph.nodes[curr].get(0) == last) return 1;
// 		if (map.containsKey(new Key(last, curr))) return map.get(new Key(last, curr));

// 		List<Integer> node = graph.nodes[curr];
// 		int height = 1;

// 		for (int i = 0; i < node.size(); i++) {
// 			if (node.get(i) == last) continue;

// 			height = Math.max(height, 1 + getHeight(graph, curr, node.get(i), map));
// 		}

// 		map.put(new Key(last, curr), height);
// 		return height;
// 	}
// }

// Topo Sort + BFS: 88% 12ms
// 将入度为 1 的节点一层一层去掉，最后一层的节点就是要的结果
public class LeetCode310MinimumHeightTrees {

	// 使用邻接表存储图
	private class Graph {
		List<Integer>[] nodes;
		int[] indegree;

		Graph(int nodeNum) {
			this.nodes = new List[nodeNum];
			this.indegree = new int[nodeNum];

			for (int i = 0; i < nodeNum; i++) {
				this.nodes[i] = new ArrayList<>();
			}
		}

		void add(int i, int j) {
			nodes[i].add(j);
			indegree[j]++;
		}
	}

	// Topo Sort: 88% 12ms
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 0) return Collections.EMPTY_LIST;
		if (n == 1) return new ArrayList<>(Arrays.asList(0));

		Graph graph = new Graph(n);
		List<Integer> res = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < edges.length; i++) {
			graph.add(edges[i][0], edges[i][1]);
			graph.add(edges[i][1], edges[i][0]);
		}

		// 把入度为 1 的点都放进 queue
		for (int i = 0; i < n; i++) {
			if (graph.indegree[i] == 1) queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			res = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				int index = queue.poll();
				res.add(index);

				for (int j = 0; j < graph.nodes[index].size(); j++) {
					int next = graph.nodes[index].get(j);

					graph.indegree[next]--;
					if (graph.indegree[next] == 1) {
						queue.offer(next);
					}
				}
			}
		}

		return res;
	}
}