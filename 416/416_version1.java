class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int n:nums) totalSum+=n; // Get summation
        if(totalSum % 2 > 0) return false;
        totalSum/=2;
        boolean[] dp = new boolean[totalSum+1];
        dp[0] = true;
        for(int n:nums){
            for(int i = totalSum;i-n>=0;i--)
                dp[i] = dp[i] || dp[i-n];
        }
        return dp[totalSum];
    }
}
// This is a dynnamic programming problem
// Use 1d array stands for if there the summation of subset of array
// could be i(dp[i])
// in this case, dp[i] = or(dp[i-n] for n in nums if i-n >=0)
// Finally return dp[totalSum]
