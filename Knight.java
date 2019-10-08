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

    public boolean canMove() {
        return true;
    }
}