public class Rook extends ChessPiece {

    public Rook(int x, int y, int player) {
        super(x, y, player);

        if (player == 1)
            setSymbol("R");
        else
            setSymbol("r");
    }
}