public class Knight extends ChessPiece {
    
    public Knight(int row, int col, Player player) {
        super(row, col, player);

        if (player.getNumber() == 1)
            setSymbol("H");
        else
            setSymbol("h");
    }
}