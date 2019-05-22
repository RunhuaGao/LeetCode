class Solution:
    def numTrees(self, n: int) -> int:
        result = [0]*(n+1)
        result[0] = 1
        result[1] = 1
        for N in range(2,n+1):
            for i in range(1,N+1):
                result[N]+=result[i-1]*result[N-i]
        return result[n]
