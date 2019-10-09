public class Rook extends ChessPiece {

    public Rook(int row, int col, Player player) {
        super(row, col, player);

        /**
         * Sets symbol for Rook.
         */
        if (player.getNumber() == 1)
            setSymbol("R");
        else
            setSymbol("r");
    }

    public boolean canMove(int row, int col, ChessPiece[][] positions) {
        return true;
    }
}