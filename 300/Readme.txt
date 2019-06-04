Solution 1:
General DP:
dp[i](stands for the ith number in nums array) = max(dp[j]+1)(j in range(0,i) and nums[i) > nums[j])
res = max(dp)
Time Complexity: O(n^2)
Space Complexity: O(n)

-------------------------------------------------------------------
Solution 2:
Advanced DP:
Please see the link below to see detailed explanation:
https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

