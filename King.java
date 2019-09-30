public class King extends ChessPiece {

    public King(int x, int y, int player) {
        super(x, y, player);

        if (player == 1)
            setSymbol("K");
        else
            setSymbol("k");
    }
}