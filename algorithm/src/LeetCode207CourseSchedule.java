/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you
have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs,
is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0.
             So it is possible.

Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0,
             and to take course 0 you should also have finished course 1.
             So it is impossible.

Note:

The input prerequisites is a graph represented by a list of edges,
not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode207CourseSchedule {
    class Graph {
        int indegree;
        List<Integer> list;

        public Graph() {
            this.indegree = 0;
            this.list = new ArrayList<>();
        }
    }

//    // topological sort + BFS: 76%
//    // 开始先找入度为 0 的所有节点入队，然后依次出队，每次出队计数，
//    // 出队时让出队节点连接的节点入度依次减 1，如果减 1 后入度为 0 则加入队列。
//    // 最后如果出队的节点数等于总共的节点数则证明 DAG（有向无环图）
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//
//        Graph[] graph = new Graph[numCourses];
//
//        for (int i = 0; i < numCourses; i++) {
//            graph[i] = new Graph();
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            int course = prerequisites[i][0];
//            int prerequisite = prerequisites[i][1];
//
//            graph[course].list.add(prerequisite);
//            graph[prerequisite].indegree++;
//        }
//
//        Queue<Graph> queue = new LinkedList<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            if (graph[i].indegree == 0)
//                queue.offer(graph[i]);
//        }
//
//        int count = 0;
//        while (!queue.isEmpty()) {
//            Graph curr = queue.poll();
//            count++;
//
//            for (int node : curr.list) {
//                graph[node].indegree--;
//                if (graph[node].indegree == 0) queue.offer(graph[node]);
//            }
//        }
//
//        return count == numCourses;
//    }

    // DFS: 89.91%
    // visited 0 表示未访问，-1 表示正在访问，1 表示已经访问过
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph[] graphs = new Graph[numCourses];
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graphs[i] = new Graph();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graphs[course].list.add(prerequisite);
            graphs[prerequisite].indegree++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!DFS(graphs, visited, i)) return false;
        }

        return true;
    }

    private boolean DFS(Graph[] graphs, int[] visited, int entrance) {
        // 如果已经访问，证明这个节点以后都没有环
        // 如果正在访问中，这次访问表示重复访问，即存在环
        if (visited[entrance] == 1) return true;
        if (visited[entrance] == -1) return false;

        visited[entrance] = -1;
        for (int node : graphs[entrance].list) {
            if (!DFS(graphs, visited, node)) return false;
        }
        visited[entrance] = 1;

        return true;
    }
}
