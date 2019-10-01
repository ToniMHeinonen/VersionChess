public class Knight extends ChessPiece {
    
    public Knight(int row, int col, int player) {
        super(row, col, player);

        if (player == 1)
            setSymbol("H");
        else
            setSymbol("h");
    }
}