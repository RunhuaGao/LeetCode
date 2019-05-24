class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        for(int r = 0;r < row;r++){
            for(int c = 0; c < col;c++){
                if(r==0 && c==0) continue;
                int leftSum = c>0?grid[r][c-1]:Integer.MAX_VALUE;
                int topSum = r>0?grid[r-1][c]:Integer.MAX_VALUE;
                grid[r][c] = Math.min(leftSum,topSum)+grid[r][c];
            }
        }
        return grid[row-1][col-1];
    }
}

// Use the original matrix to store the dp information
// Time Complexity: O(m*n)
// Space Complexity: O(1)
