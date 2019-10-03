public class Queen extends ChessPiece {
    
    public Queen(int row, int col, Player player) {
        super(row, col, player);

        if (player.getNumber() == 1)
            setSymbol("Q");
        else
            setSymbol("q");
    }
}