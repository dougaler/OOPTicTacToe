public class colWin{

    public static boolean isColWin(int COL, String[][] internalBoard, String player)
    {
        // checks for a col win for specified player
        for(int col=0; col < COL; col++)
        {
            if(internalBoard[0][col].equals(player) &&
                    internalBoard[1][col].equals(player) &&
                    internalBoard[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }
}
