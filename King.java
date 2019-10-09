public class King extends ChessPiece {

    public King(int row, int col, Player player) {
        super(row, col, player);

        /**
         * Sets symbol for King.
         */
        if (player.getNumber() == 1)
            setSymbol("K");
        else
            setSymbol("k");
    }

    /**
     * Determines how King can move
     * @return boolean-type if King moves.
     */
    public boolean canMove() {
        return true;
    }
}