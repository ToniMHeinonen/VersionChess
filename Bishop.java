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
    public boolean canMove() {
        return true;
    }

    public boolean eat() {
        return true;
    }
}