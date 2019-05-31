# space optimization: use one dimensional array to transform the status
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        level = len(triangle)
        curr_level = 1
        default = float("inf")
        dp = [default for _ in range(level)]
        dp[0] = triangle[0][0]
        while curr_level < level:
            pos = curr_level
            while pos >=0:
                right,left = dp[pos],dp[pos-1] if pos >=1 else default
                dp[pos] = min([right,left])+triangle[curr_level][pos]
                pos-=1
            curr_level+=1
        return min(dp)
