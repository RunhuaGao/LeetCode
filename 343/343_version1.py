class Solution:
    def integerBreak(self, n: int) -> int:
        res = [0 for _ in range(n+1)]
        res[1] = 1
        res[2] = 1
        index = 3
        while index <= n:
            temp = 2
            while temp <= index//2+1:
                curr1 = temp*(index-temp)
                curr2 = temp*res[index-temp]
                res[index] = max([res[index],curr1,curr2])
                temp+=1
            index+=1
        return res[n]
