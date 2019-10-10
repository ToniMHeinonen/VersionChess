public class Pawn extends ChessPiece {
    
    public Pawn(int row, int col, Player player) {
        super(row, col, player);

        /**
         * Sets symbol for Pawn.
         */
        if (player.getNumber() == 1)
            setSymbol("P");
        else
            setSymbol("p");
    }

    /**
     * Determines how Pawn can move
     * @return boolean-type if Pawn can move.
     */
    public boolean canMove(int row, int col, ChessPiece[][] positions) {
        int colAmount = col - getCol();
        int rowAmount = row - getRow();

        // Pawn can only move max 1 column
        if (colAmount > 1 || colAmount < -1)
            return false;

        // Pawn has to move in rows and can never move more than 2
        if (rowAmount == 0 || rowAmount > 2 || rowAmount < -2)
            return false;
        
        if (getPlayer().getNumber() == 1) {
            // Player 1 can't move down
            if (rowAmount < 0)
                return false;

            // If player only moved forwards, check only rows
            if (colAmount == 0) {
                // Pawn can't eat pieces in front
                if (positions[row][col] != null) {
                    return false;
                }
                // If only one row was moved up
                if (rowAmount == 1) {
                    return true;
                }
                // If two rows were moved
                else if (rowAmount == 2) {
                    // Pawn can only move 2 in row 1
                    if (getRow() != 1)
                        return false;
                    
                    /* If next position is null, return true, since
                       target position was already checked */
                    if (positions[row+1][col] == null)
                        return true;
                }
            }
            // Else pawn tries to eat diagonally
            else {
                // If pawn is moving 1 row
                if (rowAmount == 1) {
                    // If it's not null, it's occupied by the opponent
                    if (positions[row][col] != null)
                        return true;
                }
            }
            
        } else {
            // Player 2 can't move up
            if (rowAmount > 0)
                return false;

            // If player only moved forwards, check only rows
            if (colAmount == 0) {
                // Pawn can't eat pieces in front
                if (positions[row][col] != null) {
                    return false;
                }
                // If only one row was moved up
                if (rowAmount == -1) {
                    return true;
                }
                // If two rows were moved
                else if (rowAmount == -2) {
                    // Pawn can only move 2 in row 1
                    if (getRow() != 6)
                        return false;
                    
                    /* If next position is null, return true, since
                       target position was already checked */
                    if (positions[row-1][col] == null)
                        return true;
                }
            }
            // Else pawn tries to eat diagonally
            else {
                // If pawn is moving 1 row
                if (rowAmount == -1) {
                    // If it's not null, it's occupied by the opponent
                    if (positions[row][col] != null)
                        return true;
                }
            }
        }
        return false;
    }


}