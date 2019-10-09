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
    public boolean canMove(int row, int col, ChessPiece positions) {
        return true;
    }
}