public class Bishop extends ChessPiece {
    
    public Bishop(int row, int col, Player player) {
        super(row, col, player);

        if (player.getNumber() == 1)
            setSymbol("B");
        else
            setSymbol("b");
    }

    /**
     * Determines how Bishop can move
     * @return boolean-type if Bishop can move.
     */
    public boolean canMove(int row, int col, ChessPiece[][] positions) {
        int colAmount = col - getCol();
        int rowAmount = row - getRow();

        // Bishop must move always the same amount of rows and columns.
        if (Math.abs(colAmount) != Math.abs(rowAmount)) {
            return false;
        }
        return true;
    }

    /**
     * Determines if Bishop can eat opponents piece.
     * @return returns true if Bishop can eat.
     */
    public boolean eat() {
        return true;
    }
}