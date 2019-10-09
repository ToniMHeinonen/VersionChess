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

    public boolean canMove() {
        return true;
    }
}