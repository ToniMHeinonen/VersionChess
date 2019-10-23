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
        }
    }
}