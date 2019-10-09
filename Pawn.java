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

    public boolean canMove() {
        return true;
    }
}