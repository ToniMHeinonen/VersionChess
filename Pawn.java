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
        boolean playerOne = getPlayer().getNumber() == 1;

        // Pawn can only move max 1 column
        if (colAmount > 1 || colAmount < -1)
            return false;

        // Pawn has to move in rows and can never move more than 2
        if (rowAmount == 0 || rowAmount > 2 || rowAmount < -2)
            return false;

        // If player is 1 and it's trying to move down, return false
        if (playerOne && rowAmount < 0)
            return false;
        // If player is 2 and it's trying to move up, return false
        else if (!playerOne && rowAmount > 0)
            return false;
        
        /* Change negative values to positive so we can check player 1
           and player 2 movement using same code */
        rowAmount = Math.abs(rowAmount);
        colAmount = Math.abs(colAmount);

        // If player only moved forwards, check only rows
        if (colAmount == 0) {
            // Pawn can't eat pieces in front
            if (positions[row][col] != null) {
                return false;
            }
            // If only one row was moved
            if (rowAmount == 1) {
                return true;
            }
            // If two rows were moved
            else if (rowAmount == 2) {
                int startingRow;
                int val;

                if (playerOne) {
                    startingRow = 1;
                    val = 1;
                } else {
                    startingRow = 6;
                    val = -1;
                }
                
                // Pawn can only move 2 in his starting row
                if (getRow() != startingRow)
                    return false;
                
                /* If next position is null, return true, since
                    target position was already checked */
                if (positions[row+val][col] == null)
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
            
        return false;
    }

    /**
     * Determines if King can eat opponents piece.
     * @return returns true if King can eat.
     */
    public boolean eat() {
        return true;
    }
}