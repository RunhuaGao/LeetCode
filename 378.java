// search space: minimum value and maximum value(left up and bottom right)
// how to binary: check how much elements in matrix is less than mid, if cnt > k: move to left else move to right(reduce the search space)

class Solution {
    private int row,col;
    private int[][] matrix;
    public int kthSmallest(int[][] matrix, int k) {
        row = matrix.length;col = matrix[0].length;this.matrix = matrix;
        int low = matrix[0][0],high = matrix[row-1][col-1];
        while(low < high){
            int mid = low+(high-low)/2;
            int cnt = searchLessOrEqual(mid);
            if(cnt < k) low = mid+1;
            else high = mid;
        }
        return low;
    }
    
    private int searchLessOrEqual(final int target){
            int r = row-1,c = 0,res = 0;
            while(r>=0 && c < col){
                if(matrix[r][c]<=target){
                    res+=r+1;
                    c++;
                } else {
                    r--;
                }
            }
            return res;
    }
}
// Time Complexity: O(nlog(max-min))
// Space Complexity: O(1)
