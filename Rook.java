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
        // pieces in the way. (missing the condition, when there is other
        // player's piece to be eaten)
        if (colAmount != 0 && rowAmount == 0) {
            // Rook is moving to right

            // If Rook is moving only one spot to right, 
            // check that the spot is empty or occupied by another player.
            if (colAmount == 1 && (positions[row][col] == null || positions[row][col].getPlayer() != getPlayer())) {
                return true;
            }

            if (colAmount > 1) {
                for (int i = 2; i <= colAmount; i++) {
                    if (positions[row][getCol()+i-1] != null) {
                        return false;
                    }
                    if (i == colAmount && (positions[row][col] == null || positions[row][col].getPlayer() != getPlayer())) {
                        return true;
                    }
                }
            // Rook is moving to left
            } else {
                for (int i = -1; i >= colAmount; i--) {
                    if (positions[row][getCol()+i] != null) {
                        return false;
                    }
                }
            }
        }

        // Rook is moving through rows.
        if (colAmount == 0 && rowAmount != 0) {
            // Rook is moving up
            if (rowAmount > 0) {
                for (int i = 1; i <= rowAmount; i++) {
                    if (position[getRow()+i][col] != null) {
                        return false;
                    }
                }
            // Rook is moving down
            } else {
                for (int i = -1; i >= rowAmount; i--) {
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