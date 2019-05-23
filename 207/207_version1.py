class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        self.nodes = [[] for _ in range(numCourses)]
        self.visited = [0 for _ in range(numCourses)]
        for curr,pre in prerequisites:
            self.nodes[pre].append(curr)
        for n in range(numCourses):
            if self.dfs(n): return False
        return True
    def dfs(self,node):
        if self.visited[node]==1:
            return True
        if self.visited[node]==2:
            return False
        self.visited[node] = 1
        for i in self.nodes[node]:
            if self.dfs(i):return True
        self.visited[node] = 2
        return False
