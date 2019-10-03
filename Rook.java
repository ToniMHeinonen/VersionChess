public class Rook extends ChessPiece {

    public Rook(int row, int col, Player player) {
        super(row, col, player);

        if (player.getNumber() == 1)
            setSymbol("R");
        else
            setSymbol("r");
    }
}