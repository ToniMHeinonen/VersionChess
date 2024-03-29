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
    public boolean canMove(int row, int col, ChessPiece[][] positions) {
        int colAmount = col - getCol();
        int rowAmount = row - getRow();

        // King can only move one spot at a time.
        if (Math.abs(colAmount) > 1 || Math.abs(rowAmount) > 1) {
            return false;
        }

        // If King is moving diagonally, it must always move same amount of rows and columns.
        if (rowAmount != 0 && colAmount != 0) {
            if (Math.abs(rowAmount) != Math.abs(colAmount)) {
                return false;
            }
        }

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