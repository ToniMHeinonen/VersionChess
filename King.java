public class King extends ChessPiece {

    public King(int row, int col, Player player) {
        super(row, col, player);

        if (player.getNumber() == 1)
            setSymbol("K");
        else
            setSymbol("k");
    }
}