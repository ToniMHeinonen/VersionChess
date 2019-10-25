public class TicTacToe {
    private String[][] TTTBoard;
    private int[] position;

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
                TTTBoard[row][col] = "X";
                checkWin();
                break;
            }
        }
    }

    public boolean checkWin() {
        int hCounter = 0;
        int vCounter = 0;
        int dCounterUpDown = 0;
        int dCounterDownUp = 0;
        int counter = 2;

        for (int i = 0; i < 3; i++) {

            // Check if player has 3 marks in a row diagonally.
            if (TTTBoard[i][i] == "X") {
                dCounterUpDown++;
            } else {
                dCounterUpDown = 0;
            }

            // Check if player has 3 marks in a row diagonally.
            if (TTTBoard[i][counter] == "X") {
                dCounterDownUp++;
            } else {
                dCounterDownUp = 0;
            }
            counter--;

            if (dCounterUpDown == 3 || dCounterDownUp == 3) {
                return true;
            }

            for (int j = 0; j < 3; j++) {

                // Check if player has 3 marks in a row horizontally.
                if (TTTBoard[i][j] == "X") {
                    hCounter++;
                } else {
                    hCounter = 0;
                }

                // Check if player has 3 marks in a row vertically.
                if (TTTBoard[j][i] == "X") {
                    vCounter++;
                } else {
                    vCounter = 0;
                }

                // Return true, if player has won.
                if (hCounter == 3 || vCounter == 3) {
                    return true;
                }
            }
        }

        return false;
    }
}