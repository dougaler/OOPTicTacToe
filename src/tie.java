public class tie{
    public static boolean isTie(int ROW, int COL, String[][] internalBoard)
    {
        boolean xFlag = false;
        boolean oFlag = false;
        // Check all 8 win vectors for an X and O so
        // no win is possible
        // Check for row ties
        for(int row=0; row < ROW; row++)
        {
            if(internalBoard[row][0].equals("X") ||
                    internalBoard[row][1].equals("X") ||
                    internalBoard[row][2].equals("X"))
            {
                xFlag = true; // there is an X in this row
            }
            if(internalBoard[row][0].equals("O") ||
                    internalBoard[row][1].equals("O") ||
                    internalBoard[row][2].equals("O"))
            {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a row win
            }

            xFlag = oFlag = false;

        }
        // Now scan the columns
        for(int col=0; col < COL; col++)
        {
            if(internalBoard[0][col].equals("X") ||
                    internalBoard[1][col].equals("X") ||
                    internalBoard[2][col].equals("X"))
            {
                xFlag = true; // there is an X in this col
            }
            if(internalBoard[0][col].equals("O") ||
                    internalBoard[1][col].equals("O") ||
                    internalBoard[2][col].equals("O"))
            {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a col win
            }
        }
        // Now check for the diagonals
        xFlag = oFlag = false;

        if(internalBoard[0][0].equals("X") ||
                internalBoard[1][1].equals("X") ||
                internalBoard[2][2].equals("X") )
        {
            xFlag = true;
        }
        if(internalBoard[0][0].equals("O") ||
                internalBoard[1][1].equals("O") ||
                internalBoard[2][2].equals("O") )
        {
            oFlag = true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }
        xFlag = oFlag = false;

        if(internalBoard[0][2].equals("X") ||
                internalBoard[1][1].equals("X") ||
                internalBoard[2][0].equals("X") )
        {
            xFlag =  true;
        }
        if(internalBoard[0][2].equals("O") ||
                internalBoard[1][1].equals("O") ||
                internalBoard[2][0].equals("O") )
        {
            oFlag =  true;
        }
        return xFlag && oFlag; // No tie can still have a diag win

        // Checked every vector so I know I have a tie
    }
}
