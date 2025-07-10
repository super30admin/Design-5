"""
Use visiting to detect cycles in the current DFS path
Apply memo to skip already-safe nodes (DP optimization)
For each course, if DFS fails (cycle found), return False
"""
"""
Time Complexity: O(V + E) - One pass per node and edge
Space Complexity: O(V + E) for graph + O(V) for visit and memo
"""
from collections import defaultdict

class courseSchedule:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        graph = defaultdict(list)
        for course, prereq in prerequisites:
            graph[course].append(prereq)

        visit = set()     
        memo = set()     

        def dfs(course):
            if course in memo:
                return True
            if course in visit:
                return False 

            visit.add(course)
            for prereq in graph[course]:
                if not dfs(prereq):
                    return False
            visit.remove(course)
            memo.add(course)  
            return True

        for c in range(numCourses):
            if not dfs(c):
                return False
        return True

if __name__ == "__main__":

    obj = courseSchedule()   
    
    numCourses = 4
    prerequisites = [[1,0],[2,1],[3,2]]
    print(obj.canFinish(numCourses, prerequisites))
