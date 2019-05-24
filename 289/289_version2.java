// in place solution: Use static flag to store the information
// The key point is to store the information when the current point need to reverse it's status
class Solution {
    private int[][] currentState;
    private int row;
    private int col;
    private static int LIVE = 1;
    private static int DEAD = 0;
    private static int LIVEVERSA = 2;
    private static int DEADVERSA = 3;
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
                    if(liveNum < 2 || liveNum > 3) currentStatus = LIVEVERSA;
                } else {
                    if(liveNum == 3) currentStatus = DEADVERSA;
                }
                board[i][v] = currentStatus;
            }
        }
        for(int i = 0;i<row;i++){
            for(int v = 0;v<col;v++){
                if(board[i][v]==LIVEVERSA) board[i][v] = DEAD;
                else if(board[i][v]==DEADVERSA) board[i][v] = LIVE;
                else continue;
            }
        }
    }
    
    private int neighborLiveCell(int r,int c){
        // make sure the dimension right
        if(assertPosition(r,c)==false) return -1;
        int liveNum = 0;
        int neighborStatus;
        for(int i = r - 1;i <= r+1;i++){
            for(int v = c - 1;v<=c+1;v++){
                boolean identical = r==i && v==c;
                if(identical==false && assertPosition(i,v)==true){
                    neighborStatus = currentState[i][v];
                    if(neighborStatus < 2) liveNum+=neighborStatus;
                    else if(neighborStatus == LIVEVERSA) liveNum+=LIVE;
                    else if(neighborStatus == DEADVERSA) liveNum+=DEAD;
                    else continue;
                }
            }
        }
        return liveNum;
    }
    
    private boolean assertPosition(int r, int c){
        if(r < 0 || r >= row || c < 0 || c >= col) return false;
        return true;
    }
}
