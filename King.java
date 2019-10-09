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
     * @return boolean-type when King can move.
     */
    public boolean canMove(int row, int col, ChessPiece positions) {
        return true;
    }

    /**
     * Determines if King can eat opponents piece.
     * @return returns true if King can eat.
     */
    public boolean eat() {
        return true;
    }
}