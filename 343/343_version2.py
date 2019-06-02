class Solution:
    def integerBreak(self, n: int) -> int:
        self.cache = [0 for _ in range(n+1)]
        self.cache[1] = 1
        self.cache[2] = 1
        return self.recur(n)
    
    def recur(self,n):
        if n<=2:
            return self.cache[n]
        elif self.cache[n] > 0:
            return self.cache[n]
        temp = 1
        res = 0
        while temp <= n//2+1:
            	option1 = temp * self.recur(n-temp)
		option2 = temp * (n-temp)
		res = max([res,option1,option2])
		temp+=1
        self.cache[n] = res
        return self.cache[n]
