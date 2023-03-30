public class theBoard {
    private static final int ROW = 3;
    private static final int COL = 3;
    public static final String[][] internalBoard = new String[ROW][COL];

    public String controller(int newRow, int newCol, String player){
        internalBoard[newRow][newCol] = player;
        String Result = " ";

        if (colWin.isColWin(COL,internalBoard,player) || diagWin.isDiagonalWin(internalBoard,player) || rowWin.isRowWin(ROW, internalBoard, player)) {
            Result = "Win!";
        } else if (tie.isTie(ROW,COL,internalBoard)) {
            Result = "Tie!";
        }

        return Result;
    }

    public static void clearBoard(){
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                internalBoard[i][j] = " ";
            }
        }
    }
}
