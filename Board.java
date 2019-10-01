public class Board {

    private ChessPiece[][] positions = new ChessPiece[8][8];

    public Board() {
        initializeChess();
    }

    private void initializeChess() {
        // Add chess pieces for player 1 and 2
        addChessPieces(1);
        addChessPieces(2);
    }

    /**
     * Add chess pieces for players 1 and 2
     * @param player which player owns the pieces
     */
    private void addChessPieces(int player) {
        int row, pawnRow;

        if (player == 1) {
            row = 0;
            pawnRow = 1;
        } else {
            row = 7;
            pawnRow = 6;
        }
        
        positions[row][0] = new Rook(row, 0, player);
        positions[row][1] = new Knight(row, 1, player);
        positions[row][2] = new Bishop(row, 2, player);
        positions[row][3] = new Queen(row, 3, player);
        positions[row][4] = new King(row, 4, player);
        positions[row][5] = new Bishop(row, 5, player);
        positions[row][6] = new Knight(row, 6, player);
        positions[row][7] = new Rook(row, 7, player);

        // Add pawns for player 1 and 2
        for (int i = 0; i < 8; i++) {
            positions[pawnRow][i] = new Pawn(pawnRow, i, 1);
            positions[pawnRow][i] = new Pawn(pawnRow, i, 2);
        }
    }

    public void play() {

    }
}