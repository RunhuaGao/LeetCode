// idea: compare two isLands if they can be translated with each other
// use the inital point's distance, if all other points in one isLand could be mapped into another isLand with a distance, then two isLands
// can be translated
// idea: OOD, package the isLand and point object, make it eaiser to compare two isLands

class Solution {
    
     class IsLand{
        private List<Point> points;
        public IsLand(){
            points = new ArrayList<>();
        }
        
        public int size() {
            return points.size();
        }
        
        public Point getPoint(final int index){
            return points.get(index);
        }
        
        public Point initialPoint(){
            return getPoint(0);
        }
         
        public void addPoint(Point point){points.add(point);}
    }
    
    class Point{
        int x,y;
        
        public Point(final int _x,final int _y){
            x = _x;y=_y;
        }
        
        public Point transPoint(final int xDis,final int yDis){
            return new Point(x+xDis,y+yDis);
        }
        
        public boolean equals(Point point){
            return x == point.x && y == point.y;
        }
    }
    
    private int[][] grid;
    private int row,col;
    
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        List<IsLand> isLands = new ArrayList<>();
        row = grid.length;col = grid[0].length;
        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(grid[r][c]==1){
                    IsLand isLand = new IsLand();
                    dfs(r,c,isLand);
                    boolean seen = false;
                    for(final IsLand oldland:isLands){
                        if(compareIsland(isLand,oldland)){
                            seen = true;break;
                        }
                    }
                    if(!seen) isLands.add(isLand);
                }
            }
        }
        return isLands.size();
    }
    
    
    
    private void dfs(int r,int c,IsLand isLand){
        if(inRange(r,c) && grid[r][c]==1){
            isLand.addPoint(new Point(r,c));
            grid[r][c] = 0;
            dfs(r-1,c,isLand);dfs(r+1,c,isLand);
            dfs(r,c-1,isLand);dfs(r,c+1,isLand);
        }
    }
    
    private boolean inRange(final int r,final int c){
        return r>=0 && r < row && c>=0 && c < col;
    }
    
    
    private boolean compareIsland(IsLand isLand1,IsLand isLand2){
        if(isLand1.size()!=isLand2.size()) return false;
        int[] distance = transDistance(isLand1.initialPoint(),isLand2.initialPoint());
        for(int index = 0;index<isLand1.size();index++){
            Point isLand1Point = isLand1.getPoint(index);
            Point isLand2Point = isLand2.getPoint(index);
            Point transPoint = isLand2Point.transPoint(distance[0],distance[1]);
            if(!isLand1Point.equals(transPoint)) return false;
        }
        return true;
    }
    
    
    private int[] transDistance(final Point point1, final Point point2){
        return new int[] {point1.x-point2.x,point1.y-point2.y};
    }
    
}
