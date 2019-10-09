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
            if (colAmount > 0) {
                for (int i = 1; i <= colAmount; i++) {
                    if (positions[row][col+i] != null) {
                        return false;
                    }
                }
            // Rook is moving to left
            } else {
                for (int i = -1; i >= colAmount; i--) {
                    if (positions[row][col+i] != null) {
                        return false;
            }
        }

        return true;
    }
}