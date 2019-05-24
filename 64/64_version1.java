class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int r = 0;r < row;r++){
            for(int c = 0; c < col;c++){
                if(r==0 && c==0) continue;
                int leftSum = c>0?dp[r][c-1]:Integer.MAX_VALUE;
                int topSum = r>0?dp[r-1][c]:Integer.MAX_VALUE;
                dp[r][c] = Math.min(leftSum,topSum)+grid[r][c];
            }
        }
        return dp[row-1][col-1];
    }
}
