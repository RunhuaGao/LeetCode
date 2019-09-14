class Solution {
    private int[][] isLand;
    private int rowLimit;
    private int colLimit;
    private Set<Integer> visitedPoints;
    public int numEnclaves(int[][] A) {
        isLand = A;
        rowLimit = A.length;
        colLimit = A[0].length;
        visitedPoints = new HashSet<>();
        int res = 0;
        for(int i = 0;i<rowLimit;i++){
            for(int j = 0;j<colLimit;j++){
                int[] point = new int[] {i,j};
                if(!visitedPoints.contains(rcTo1D(point)) && isLand[i][j]==1) res+=bfs(i,j);
            }
        }
        return res;
    }
    
    
    private int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int area = 0;
        boolean boundary = false;
        // initialize bfs search through the isLand
        while (queue.size() > 0) {
            int[] point = queue.poll();
            int row = point[0], col = point[1];
            if (!inRange(point) || isLand[row][col] == 0 || visitedPoints.contains(rcTo1D(point))) continue;
            if (onBoundary(row, col)) boundary = true;
            area++;
            visitedPoints.add(rcTo1D(point));
            int[] leftPoint = new int[]{row, col - 1};queue.add(leftPoint);
            int[] rightPoint = new int[]{row, col + 1};queue.add(rightPoint);
            int[] upPoint = new int[]{row - 1, col};queue.add(upPoint);
            int[] downPoint = new int[]{row + 1, col};queue.add(downPoint);
        }
        return boundary ? 0 : area;
    }
    
    
    private boolean onBoundary(int r,int c){
        return r==0 || r==rowLimit-1 || c==0 || c==colLimit-1;
    }
    
    private int rcTo1D(int[] point){
        return point[0]*colLimit+point[1];
    }
    
    private boolean inRange(int[] point){
        return point[0] >=0 && point[0] < rowLimit && point[1] >=0 && point[1] < colLimit;
    }
    
    
}
// do not change original board
