public class Knight extends ChessPiece {
    
    public Knight(int x, int y, int player) {
        super(x, y, player);

        if (player == 1)
            setSymbol("H");
        else
            setSymbol("h");
    }
}