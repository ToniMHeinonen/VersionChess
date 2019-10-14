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
        int colAmount = col - getCol();
        int rowAmount = row - getRow();

        // Rook can only move columns or rows, not both
        if (colAmount != 0 && rowAmount != 0)
        return false;

        // If rook is moving through columns, check that there are no
        // pieces in the way.
        if (colAmount != 0 && rowAmount == 0) {

            // If Rook is moving more than one spot to right,
            // check that all spots are empty between starting-point
            // and end-point.
            if (colAmount > 1) {
                for (int i = 1; i < colAmount; i++) {
                    if (positions[row][getCol()+i] != null) {
                        return false;
                    }
                }
            // Rook is moving to left more than one spot.
            } else {
                for (int i = -1; i > colAmount; i--) {
                    if (positions[row][getCol()+i] != null) {
                        return false;
                    }
                }
            }
        }

        // Rook is moving through rows.
        if (colAmount == 0 && rowAmount != 0) {

            // If Rook is moving more than one spot to up,
            // check that all spots are empty between starting-point
            // and end-point.
            if (rowAmount > 1) {
                for (int i = 1; i < rowAmount; i++) {
                    if (positions[getRow()+i][col] != null) {
                        return false;
                    }
                }
            // Rook is moving to down more than one spot.
            } else {
                for (int i = -1; i > rowAmount; i--) {
                    if (positions[getRow()+i][col] != null) {
                        return false;
                    }
                }
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