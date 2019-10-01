public class Queen extends ChessPiece {
    
    public Queen(int row, int col, int player) {
        super(row, col, player);

        if (player == 1)
            setSymbol("Q");
        else
            setSymbol("q");
    }
}