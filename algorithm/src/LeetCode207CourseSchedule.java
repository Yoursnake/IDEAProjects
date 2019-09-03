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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode207CourseSchedule {
    class Graph {
        int indegree;
        List<Integer> list;
    }

    // topological sort + bfs: 76%
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph[] graph = new Graph[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new Graph();
            graph[i].indegree = 0;
            graph[i].list = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int prerequisite = prerequisites[i][0];

            graph[course].list.add(prerequisite);
            graph[prerequisite].indegree++;
        }

        Queue<Graph> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (graph[i].indegree == 0)
                queue.offer(graph[i]);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Graph curr = queue.poll();
            count++;

            for (int node : curr.list) {
                graph[node].indegree--;
                if (graph[node].indegree == 0) queue.offer(graph[node]);
            }
        }

        return count == numCourses;
    }
}
