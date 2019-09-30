public class Bishop extends ChessPiece {
    
    public Bishop(int x, int y, int player) {
        super(x, y, player);

        if (player == 1)
            setSymbol("B");
        else
            setSymbol("b");
    }
}