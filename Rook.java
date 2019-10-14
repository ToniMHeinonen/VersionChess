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
                for (int i = 2; i <= colAmount; i++) {
                    if (positions[row][getCol()+i-1] != null) {
                        return false;
                    }
                    // Check that the final spot is empty or occupied by another player.
                    if (i == colAmount && (positions[row][col] == null || positions[row][col].getPlayer() != getPlayer())) {
                        return true;
                    }
                }
            // Rook is moving to left more than one spot.
            } else {
                for (int i = -2; i >= colAmount; i--) {
                    if (positions[row][getCol()+i+1] != null) {
                        return false;
                    }
                    // Check that the final spot is empty or occupied by another player.
                    if (i == colAmount && (positions[row][col] == null || positions[row][col].getPlayer() != getPlayer())) {
                        return true;
                    }
                }
            }
        }

        // Rook is moving through rows.
        if (colAmount == 0 && rowAmount != 0) {

            // If Rook is moving only one spot to up or down, 
            // check that the spot is empty or occupied by another player.
            if ((rowAmount == 1 || rowAmount == -1) && 
            (positions[row][col] == null || positions[row][col].getPlayer() != getPlayer())) {
                return true;
            }

            // If Rook is moving more than one spot to up,
            // check that all spots are empty between starting-point
            // and end-point.
            if (rowAmount > 1) {
                for (int i = 2; i <= rowAmount; i++) {
                    if (positions[getRow()+i-1][col] != null) {
                        return false;
                    }
                    // Check that the final spot is empty or occupied by another player.
                    if (i == rowAmount && (positions[row][col] == null || positions[row][col].getPlayer() != getPlayer())) {
                        return true;
                    }
                }
            // Rook is moving to down more than one spot.
            } else {
                for (int i = -2; i >= rowAmount; i--) {
                    if (positions[getRow()+i+1][col] != null) {
                        return false;
                    }
                    // Check that the final spot is empty or occupied by another player.
                    if (i == rowAmount && (positions[row][col] == null || positions[row][col].getPlayer() != getPlayer())) {
                        return true;
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