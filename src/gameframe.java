import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class gameframe extends JFrame
{
    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;
    JTextArea displayTA;
    JScrollPane scroller;
    JLabel titleLbl;
    ImageIcon icon;
    String theResult;
    JButton quitBtn;
    JButton restartBtn;
    private static final int ROW = 3;
    private static final int COL = 3;

    private static final JButton[][] board = new JButton[ROW][COL];


    int count=1;
    String player;


    theBoard tisAResult = new theBoard();

    /**
     *  Method to provide layout for the java swing
     */
    public gameframe()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.CENTER);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     *  Method to create the layout for the specific Top Label panel for the swing program
     */
    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/fortuneteller.jpg");
        titleLbl = new JLabel("Rock Paper Scissors!", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Courier", Font.BOLD,30));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }

    /**
     *  Method that contains the game portion of the project. This is where the player will control the game.
     */
    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(3, 3));

        for (int i = 0; i <ROW; i++){
            for (int j = 0; j <COL; j++) {
                board[i][j] = new JButton(" ");
                controlPnl.add(board[i][j]);
                board[i][j].setText(" ");

                int finalI = i;
                int finalJ = j;
                theBoard.clearBoard();
                board[i][j].addActionListener((ActionEvent ae) -> {
                    while (count<=9 && theBoard.internalBoard[finalI][finalJ].equals(" ")) {
                        if (count % 2 == 1) {
                            board[finalI][finalJ].setText("X");
                            count++;
                            player = "X";
                            theResult = tisAResult.controller(finalI, finalJ, player);
                            doesGameEnd();
                        } else if (count % 2 == 0) {
                            board[finalI][finalJ].setText("O");
                            player = "O";
                            count++;
                            theResult = tisAResult.controller(finalI, finalJ, player);
                            doesGameEnd();
                        } else {
                            displayTA.append("Illegal Move\n");

                        }
                    }
                });
            }
        }

    }
    /**
     *  Method to provide layout and details of the results. It shows all the win details as well as the results of each game played
     */
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayPnl.setLayout(new GridLayout(3, 1));

        displayTA = new JTextArea(10, 15);

        displayTA.setEditable(false);

        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
        quitBtn = new JButton("Quit");
        restartBtn = new JButton("Restart");
        displayPnl.add(quitBtn);
        displayPnl.add(restartBtn);

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        restartBtn.addActionListener((ActionEvent ae) -> playAgain());

    }
    private void playAgain()
    {
        for (int i = 0; i <ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j].setText(" ");
            }
        }
        count = 1;
        theBoard.clearBoard();
    }

    private void doesGameEnd(){
        if (theResult.equals("Win!")) {
            count = 10;
            displayTA.append(player + " wins!\n");
            displayTA.append("Press restart to play again!\n");
        } else if (theResult.equals("Tie!")) {
            count = 10;
            displayTA.append("Tie!\n");
            displayTA.append("Press restart to play again!\n");
        }
    }

}
