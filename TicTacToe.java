public class TicTacToe {
    private String[][] TTTBoard;

    public TicTacToe() {
        initializeTTT();
    }

    public void initializeTTT() {
        TTTBoard = new String[3][3];
        Print.ticTacToeBoard();
    }

    public void play() {
        
    }
}