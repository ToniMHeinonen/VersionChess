public class Pawn extends ChessPiece {
    
    public Pawn(int x, int y, int player) {
        super(x, y, player);

        if (player == 1)
            setSymbol("P");
        else
            setSymbol("p");
    }
}