public class Board {

    private ChessPiece[][] positions = new ChessPiece[8][8];

    public Board() {
        initializeChess();
    }

    private void initializeChess() {
        addChessPieces(0, 1);
        addChessPieces(7, 2);

        for (int i = 0; i < 8; i++) {
            positions[1][i] = new Pawn(1, i, 1);
            positions[6][i] = new Pawn(6, i, 2);
        }
    }

    /**
     * Adds all chess pieces to the board except pawns.
     * @param index row to add
     * @param player which player owns the piece
     */
    private void addChessPieces(int index, int player) {
        positions[index][0] = new Rook(index, 0, player);
        positions[index][1] = new Knight(index, 1, player);
        positions[index][2] = new Bishop(index, 2, player);
        positions[index][3] = new Queen(index, 3, player);
        positions[index][4] = new King(index, 4, player);
        positions[index][5] = new Bishop(index, 5, player);
        positions[index][6] = new Knight(index, 6, player);
        positions[index][7] = new Rook(index, 7, player);
    }

    public void play() {

    }
}