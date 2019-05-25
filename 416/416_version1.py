class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        totalSum = sum(nums)
        if totalSum%2 > 0:
            return False
        totalSum//=2
        dp = [False for _ in range(totalSum+1)]
        dp[0] = True
        for n in nums:
            curr = totalSum
            while curr-n>=0:
                dp[curr] = dp[curr] or dp[curr-n]
                curr-=1
        return dp[totalSum]
