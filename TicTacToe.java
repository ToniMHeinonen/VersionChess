public class TicTacToe {
    private String[][] TTTBoard;
    private int[] position;
    private String playerMark = "X";
    private String AIMark = "O";

    public TicTacToe() {
        initializeTTT();
    }

    public void initializeTTT() {
        TTTBoard = new String[3][3];
        Print.ticTacToeBoard(TTTBoard);
    }

    public void play() {
        while (true) {
            Print.msg("Put yor mark in:");
            position = Input.getSelectedPosition(3);
            int row = position[0];
            int col = position[1];
            if (TTTBoard[row][col] != null) {
                Print.error("Spot is already occupied");
            } else {
                TTTBoard[row][col] = playerMark;
                Print.ticTacToeBoard(TTTBoard);
                aiTurn();
                Print.ticTacToeBoard(TTTBoard);
            }
            if (checkWin(playerMark)) {
                System.out.println("Player wins!");
                break;
            }
            if (checkWin(AIMark)) {
                System.out.println("AI wins!");
                break;
            }
        }
    }

    public void aiTurn() {
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                if (TTTBoard[i][j] == null) {
                    TTTBoard[i][j] = AIMark;
                    break;
                }
            }
        }
    }

    public boolean checkWin(String mark) {
        int hCounter = 0;
        int vCounter = 0;
        int dCounterUpDown = 0;
        int dCounterDownUp = 0;
        int counter = 2;

        for (int i = 0; i < 3; i++) {

            // Check if player has 3 marks in a row diagonally.
            if (TTTBoard[i][i] == mark) {
                dCounterUpDown++;
            } else {
                dCounterUpDown = 0;
            }

            // Check if player has 3 marks in a row diagonally.
            if (TTTBoard[i][counter] == mark) {
                dCounterDownUp++;
            } else {
                dCounterDownUp = 0;
            }
            counter--;

            for (int j = 0; j < 3; j++) {

                // Check if player has 3 marks in a row horizontally.
                if (TTTBoard[i][j] == mark) {
                    hCounter++;
                } else {
                    hCounter = 0;
                }

                // Check if player has 3 marks in a row vertically.
                if (TTTBoard[j][i] == mark) {
                    vCounter++;
                } else {
                    vCounter = 0;
                }
            }

            // If player has 3 marks in a row, return true.
            if (dCounterUpDown == 3 || dCounterDownUp == 3 || hCounter == 3 || vCounter == 3) {
                return true;
            }
        }

        return false;
    }
}