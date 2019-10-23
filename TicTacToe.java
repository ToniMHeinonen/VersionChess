public class TicTacToe {
    private String[][] TTTBoard;
    private int[] position;

    public TicTacToe() {
        initializeTTT();
    }

    public void initializeTTT() {
        TTTBoard = new String[3][3];
        Print.ticTacToeBoard();
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
                break;
            }
        }
    }

    public void checkWin() {
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (TTTBoard[i][j] == "X") {
                    counter++;
                } else {
                    counter = 0;
                }
            }
        }
    }
}