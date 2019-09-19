class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // idea : reduce space search
        int row = matrix.length-1,col = 0;
        while(row >=0 && col < matrix[0].length){
            int currValue = matrix[row][col];
            if(currValue==target) return true;
            else if(currValue < target) col++;
            else row--;
        }
        return false;
    }
    // tricky point here is that, if we start from bottom-left point
    // the new point will always be the bottom-left point of the reduced search space
    // time complexity O(m+n)
    // space complexity O(1)
}
