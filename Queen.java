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

        // If Queen is moving diagonally, it must always move same amount of rows and columns.
        if (rowAmount != 0 && colAmount != 0) {
            if (Math.abs(rowAmount) != Math.abs(colAmount)) {
                return false;
            }
        }

        // Queen is moving right or left.
        if (rowAmount == 0 && colAmount != 0) {

            // Queen is moving right.
            if (colAmount > 1) {
                for (int i = 1; i < colAmount; i++) {
                    if (positions[row][getCol()+i] != null) {
                        return false;
                    }
                }
            }

            // Queen is moving left.
            if (colAmount < -1) {
                for (int i = -1; i > colAmount; i--) {
                    if (positions[row][getCol()+i] != null) {
                        return false;
                    }
                }
            }
        }

        // Queen is moving up or down.
        if (rowAmount != 0 && colAmount == 0) {

            // Queen is moving up.
            if (rowAmount > 1) {
                for (int i = 1; i < rowAmount; i++) {
                    if (positions[getRow()+i][col] != null) {
                        return false;
                    }
                }
            }

            // Queen is moving down.
            if (rowAmount < -1) {
                for (int i = -1; i > rowAmount; i--) {
                    if (positions[getRow()+i][col] != null) {
                        return false;
                    }
                }
            }
        }

        // Queen is moving up and right.
        if (colAmount > 1 && rowAmount > 1) {
            for (int i = 1; i < colAmount; i++) {
                if (positions[getRow()+i][getCol()+i] != null) {
                    return false;
                }
            }
        }

        // Queen is moving down and left.
        if (colAmount < -1 && rowAmount < -1) {
            for (int i = -1; i > colAmount; i--) {
                if (positions[getRow()+i][getCol()+i] != null) {
                    return false;
                }
            }
        }

        if (colAmount > 1 && rowAmount < -1) {
            for (int i = -1; i > rowAmount; i--) {
                if (positions[getRow()+i][getCol()+Math.abs(i)] != null) {
                    return false;
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