public class Queen extends ChessPiece {
    
    public Queen(int x, int y, int player) {
        super(x, y, player);

        if (player == 1)
            setSymbol("Q");
        else
            setSymbol("q");
    }
}