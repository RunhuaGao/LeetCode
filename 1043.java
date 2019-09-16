// state transfermation formula: dp[i] equlas maximum summation could get from A[0]to A[i]
// dp[i] = max(dp[i-k] + max(dp[i-k+1,k<=K])*k)
// time complexity: O(MN)
// spcae complexity: O(N)
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        // idea: dynamic programming: this is a optimal problem so could not use greedy algorithm
        int[] dp = new int[A.length];
        for(int i = 0;i<A.length;i++){
            int currMax = 0;
            for(int k = 1;i-k+1>=0&&k<=K;k++){
                currMax = Math.max(currMax,A[i-k+1]);
                dp[i] = Math.max(dp[i],(i-k>=0?dp[i-k]:0)+currMax*k);
            }
        }
        return dp[A.length-1];
    }
}
