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

        // Pawn has to move in rows
        if (rowAmount == 0)
            return false;
        
        if (getPlayer().getNumber() == 1) {
            // Player 1 can't move down
            if (rowAmount < 0)
                return false;
            
        } else {
            // Player 1 can't move up
            if (rowAmount > 0)
                return false;
        }
        return true;
    }
}