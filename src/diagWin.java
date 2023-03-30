public class diagWin{
    public static boolean isDiagonalWin(String[][] internalBoard, String player)
    {
        // checks for a diagonal win for the specified player

        if(internalBoard[0][0].equals(player) &&
                internalBoard[1][1].equals(player) &&
                internalBoard[2][2].equals(player) )
        {
            return true;
        }
        return internalBoard[0][2].equals(player) &&
                internalBoard[1][1].equals(player) &&
                internalBoard[2][0].equals(player);
    }
}
