public class Knight extends ChessPiece {
    
    public Knight(int row, int col, Player player) {
        super(row, col, player);

        /**
         * Sets symbol for Knight.
         */
        if (player.getNumber() == 1)
            setSymbol("H");
        else
            setSymbol("h");
    }

    /**
     * Determines how Knight can move
     * @return boolean-type if Knight can move.
     */
    public boolean canMove(int row, int col, ChessPiece[][] positions) {
        int colAmount = Math.abs(col - getCol());
        int rowAmount = Math.abs(row - getRow());

        if ((colAmount == 1 && rowAmount == 2) ||
            (colAmount == 2 && rowAmount == 1))
            return true;
        
        return true;
    }
}