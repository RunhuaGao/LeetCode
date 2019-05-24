class Solution {
    private int[][] currentState;
    private int row;
    private int col;
    private static int LIVE = 1;
    private static int DEAD = 0;
    public void gameOfLife(int[][] board) {
        row = board.length;col = board[0].length; // Get the dimension
        int[][] newstate = new int[row][col];
        currentState = board;
        for(int i = 0;i<row;i++){
            for(int v = 0;v<col;v++){
                int liveNum = neighborLiveCell(i,v);
                if(liveNum < 0) continue;
                int currentStatus = currentState[i][v];
                if(currentStatus == LIVE){
                    if(liveNum < 2 || liveNum > 3) currentStatus = DEAD;
                } else {
                    if(liveNum == 3) currentStatus = LIVE;
                }
                newstate[i][v] = currentStatus;
            }
        }
        for(int i = 0;i<row;i++) System.arraycopy(newstate[i],0,board[i],0,col);
    }
    
    private int neighborLiveCell(int r,int c){
        // make sure the dimension right
        if(assertPosition(r,c)==false) return -1;
        int liveNum = 0;
        for(int i = r - 1;i <= r+1;i++){
            for(int v = c - 1;v<=c+1;v++){
                boolean identical = r==i && v==c;
                if(identical==false && assertPosition(i,v)==true) liveNum+=currentState[i][v];
            }
        }
        return liveNum;
    }
    
    private boolean assertPosition(int r, int c){
        if(r < 0 || r >= row || c < 0 || c >= col) return false;
        return true;
    }
}
