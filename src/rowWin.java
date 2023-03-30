public class rowWin{

    public static boolean isRowWin(int ROW, String[][] internalBoard, String player)
    {
        // checks for a row win for the specified player
        for(int row=0; row < ROW; row++)
        {
            if(internalBoard[row][0].equals(player) &&
                    internalBoard[row][1].equals(player) &&
                    internalBoard[row][2].equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }
}
