/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you
have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs,
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them.
If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you
should have finished course 0. So the correct course order is [0,1] .

Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
Accepted
 */

import java.util.*;

public class LeetCode210CourseScheduleII {
    class GraphNode {
        int indegree;
        int val;
        List<Integer> list;

        public GraphNode(int val) {
            this.val = val;
            this.indegree = 0;
            this.list = new ArrayList<>();
        }
    }

//    // topological sort + BFS: 80.16%
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        int[] result = new int[numCourses];
//        GraphNode[] graph = new GraphNode[numCourses];
//
//        for (int i = 0; i < numCourses; i++) {
//            graph[i] = new GraphNode(i);
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            int prerequisite = prerequisites[i][1];
//            int course = prerequisites[i][0];
//
//            graph[course].list.add(prerequisite);
//            graph[prerequisite].indegree++;
//        }
//
//        Queue<GraphNode> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (graph[i].indegree == 0) queue.offer(graph[i]);
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        while (!queue.isEmpty()) {
//            GraphNode currNode = queue.poll();
//            stack.push(currNode.val);
//
//            for (int node : currNode.list) {
//                graph[node].indegree--;
//                if (graph[node].indegree == 0) queue.offer(graph[node]);
//            }
//        }
//
//        if (stack.size() != numCourses) {
//            return new int[0];
//        } else {
//            for (int i = 0; i < numCourses; i++) {
//                result[i] = stack.pop();
//            }
//            return result;
//        }
//    }

    // topological sort + DFS: 96.37%
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        GraphNode[] graph = new GraphNode[numCourses];
        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new GraphNode(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph[course].list.add(prerequisite);
            graph[prerequisite].indegree++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!DFS(graph, visited, i, queue)) return new int[0];
        }

        for (int i = 0; i < numCourses; i++) {
            result[i] = queue.poll();
        }

        return result;
    }

    private boolean DFS(GraphNode[] graph, int[] visited, int entrance, Queue<Integer> queue) {
        if (visited[entrance] == 1) return true;
        if (visited[entrance] == -1) return false;

        visited[entrance] = -1;

        for (int node : graph[entrance].list) {
            if (!DFS(graph, visited, node, queue)) return false;
        }

        visited[entrance] = 1;
        queue.offer(graph[entrance].val);
        return true;
    }
}
