Typical DP problem:
Transformation function:
dp[i] = max(dp[i],j*(i-j),j*dp(i-j)) j from 1 to i-1(at least two positive integers)

Time Complexity: O(n^2)
Space Complexity: O(n)
