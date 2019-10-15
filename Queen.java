public class Queen extends ChessPiece {
    
    public Queen(int row, int col, Player player) {
        super(row, col, player);

        /**
         * Sets symbol for Queen.
         */
        if (player.getNumber() == 1)
            setSymbol("Q");
        else
            setSymbol("q");
    }

    public boolean canMove(int row, int col, ChessPiece[][] positions) {
        int colAmount = col - getCol();
        int rowAmount = row - getRow();
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