public class Bishop extends ChessPiece {
    
    public Bishop(int row, int col, int player) {
        super(row, col, player);

        if (player == 1)
            setSymbol("B");
        else
            setSymbol("b");
    }
}