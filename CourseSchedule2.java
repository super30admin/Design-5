// Leetcode link - https://leetcode.com/problems/course-schedule-ii/

// Time complexity: O(V + E) where V is the number of vertices (courses) and E is the number of edges (prerequisites)
// Space complexity: O(V + E) where V is the number of vertices (courses) and E is the number of edges (prerequisites)

// Intuition: Use DFS to traverse the graph and check if all courses can be completed. 
// We maintain an adjacency list to represent the graph and an indegree array to track the number of prerequisites for each course. 
// We start with courses that have no prerequisites and perform a depth-first search (DFS) to visit all reachable courses, 
// adding them to the result list. If we can visit all courses, we return the order; otherwise, we return an empty array.
// For visited nodes, we use a queue to store the order of courses that can be completed. 

import java.util.*;
import java.util.LinkedList;

public class CourseSchedule2 {
    List<Integer> adj[];
    Queue<Integer> queue;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        queue = new LinkedList();
        int[] indegree = new int[numCourses];

        makeGraph(numCourses, prerequisites, indegree); // pre-process
        List<Integer> starters = getStarters(indegree);

        for (int starter : starters) {
            dfs(starter, indegree);
        }

        if (queue.size() != numCourses) {
            return new int[0];
        }

        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }

    private void dfs(int node, int[] indegrees) {
        queue.add(node); // first starter should be added before dfs
        for (int neighbor : adj[node]) {
            indegrees[neighbor]--;
            if (indegrees[neighbor] == 0) {
                dfs(neighbor, indegrees);
            }
        }
    }

    public void makeGraph(int num, int[][] pre, int[] indegree) {
        adj = new ArrayList[num];
        for (int i = 0; i < num; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < pre.length; i++) {
            adj[pre[i][1]].add(pre[i][0]); // for ex in [0,1] to make edge 1->0
            indegree[pre[i][0]]++; // indegree of node 0 will be incremented
        }
    }

    private List<Integer> getStarters(int[] indegrees) {
        List<Integer> starters = new ArrayList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                starters.add(i);
            }
        }
        return starters;
    }
}
