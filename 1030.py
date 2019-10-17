// solution 1: dynamic programming
// f(i,j) = min(f(i,j),f(i,k-1)+f(k,j)+max(arr[i,k-1])*max(arr[k,j])) for k in [i+1,j]
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
// Little trick: cache to reduce calculation time
class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        self.arr = arr
        self.cache = {}
        return self.dfs(0,len(arr)-1)
    def dfs(self,left,right):
        if left >= right:
            return 0
        elif (left,right) in self.cache:
            return self.cache[(left,right)]
        else:
            res = float("inf")
            for i in range(left+1,right+1):
                res = min([res,self.dfs(left,i-1)+self.dfs(i,right)+max(self.arr[left:i])*max(self.arr[i:right+1])])
            self.cache[(left,right)] = res
            return res
            
 
 // solution 2: monotonic stack
 // matin a decreasing monotonic stack: when current value > peek value, pop it
 // res+=pop*min(currvalue,peekvalue)
 // Time Complexity: O(n)
 // Space Complexity: O(n)
 class Solution:
    def mctFromLeafValues(self, A: List[int]) -> int:
        res, n = 0, len(A)
        stack = [float('inf')]
        for a in A:
            while stack[-1] <= a:
                mid = stack.pop()
                res += mid * min(stack[-1], a)
            stack.append(a)
        while len(stack) > 2:
            res += stack.pop() * stack[-1]
        return res
