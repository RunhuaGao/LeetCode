class Solution:
    def numSquares(self, n: int) -> int:
        if n <= 1:
            return n
        result = [0, 1]
        number = 2
        while number <= n:
            value = float("inf")
            option = int(number ** 0.5)
            while option > 0 and result[number-option**2]+1 <= value:
                value = min([value, result[number - option * option] + 1])
                option -= 1
            if value != float("inf"): result.append(value)
            number += 1
        return result[-1]


print(Solution().numSquares(48))
