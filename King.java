public class King extends ChessPiece {

    public King(int row, int col, int player) {
        super(row, col, player);

        if (player == 1)
            setSymbol("K");
        else
            setSymbol("k");
    }
}