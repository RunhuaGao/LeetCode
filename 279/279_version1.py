class Solution:
    def numSquares(self, n: int) -> int:
        if n <= 1:
            return n
        result = [0, 1]
        number = 2
        while number <= n:
            value = number
            option = 1
            while number - option**2 >=0:
                value = min([value,result[number-option**2]])
                option+=1
            result.append(value)
            number += 1
        return result[-1]
