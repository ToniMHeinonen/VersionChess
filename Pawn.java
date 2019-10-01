public class Pawn extends ChessPiece {
    
    public Pawn(int row, int col, int player) {
        super(row, col, player);

        if (player == 1)
            setSymbol("P");
        else
            setSymbol("p");
    }
}