public class Bishop extends ChessPiece {
    
    public Bishop(int row, int col, Player player) {
        super(row, col, player);

        if (player.getNumber() == 1)
            setSymbol("B");
        else
            setSymbol("b");
    }

    public boolean canMove() {
        return true;
    }
}