class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[] dp = new int[col];
        for(int r = 0;r < row;r++){
            for(int c = 0; c < col;c++){
                if(r==0 && c==0){
                    dp[0] = grid[0][0];
                    continue;
                }
                int leftSum = c>0?dp[c-1]:Integer.MAX_VALUE;
                int topSum = r>0?dp[c]:Integer.MAX_VALUE;
                dp[c] = Math.min(leftSum,topSum)+grid[r][c];
            }
        }
        return dp[col-1];
    }
}

// Use only one row to store the information
// The current col is it's up summation The left point is its left summation
// Space Complexity: O(c)(column number)
// Time Complexity: O(r*c)
