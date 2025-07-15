# Time complexity: O(V + E)
# Space complexity: O(V + E) 

from collections import defaultdict

class courseSchedule:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        graph = defaultdict(list)
        for course, prereq in prerequisites:
            graph[prereq].append(course)

        visit = set()     
        memo = set()     

        def dfs(course):
            if course in memo:
                return True
            if course in visit:
                return False 

            visit.add(course)
            for next_course in graph[course]:
                if not dfs(next_course):
                    return False
            visit.remove(course)
            memo.add(course)  
            return True

        for c in range(numCourses):
            if c not in memo and not dfs(c):
                return False
        return True

