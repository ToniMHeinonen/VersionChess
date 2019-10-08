public class Board {

    private ChessPiece[][] positions = new ChessPiece[8][8];
    private Player[] players = new Player[2];
    public static final int A = 0, B = 1, C = 2, D = 3, E = 4, F = 5,
                            G = 6, H = 7;
    private Player playerTurn;
    /*
    moveFromColRow[] contains two values: column and row.
    These values are the chesspiece's position, which
    player wants to move.
    */
    private int[] moveFromColRow, moveToColRow;

    public Board() {
        initializeChess();
    }

    /**
     * Creates the board and players
     * 
     * Gets the player names from the user and adds the chess pieces.
     */
    private void initializeChess() {
        initializePlayers();
        
        // Add chess pieces for player 1 and 2
        addChessPieces();
    }

    /**
     * Add chess pieces for players 1 and 2
     */
    private void addChessPieces() {
        for (Player p : players) {
            int row, pawnRow;

            if (p.getNumber() == 1) {
                row = 0;
                pawnRow = 1;
            } else {
                row = 7;
                pawnRow = 6;
            }
            
            positions[row][0] = new Rook(row, 0, p);
            positions[row][1] = new Knight(row, 1, p);
            positions[row][2] = new Bishop(row, 2, p);
            positions[row][3] = new Queen(row, 3, p);
            positions[row][4] = new King(row, 4, p);
            positions[row][5] = new Bishop(row, 5, p);
            positions[row][6] = new Knight(row, 6, p);
            positions[row][7] = new Rook(row, 7, p);

            // Add pawns
            for (int i = 0; i < 8; i++) {
                positions[pawnRow][i] = new Pawn(pawnRow, i, p);
            }
        }   
    }

    private void initializePlayers() {
        Print.msg("Give name to player 1:");
        players[0] = new Player(Input.getString(), 1);
        Print.msg("Give name to player 2:");
        players[1] = new Player(Input.getString(), 2);
        playerTurn = players[0];
    }

    public void play() {
        Print.board(positions);
        moveFrom();
    }

    public Player getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Change turn
     * 
     * If it's currently player one's turn, change to player two
     * and vice versa.
     */
    public void nextTurn() {
        if (playerTurn == players[0])
            playerTurn = players[1];
        else
            playerTurn = players[0];
    }

    /**
     * Get position of the chesspiece that players wants to move.
     */
    public void moveFrom() {
        Print.msg(playerTurn.getName() + 
        ", which chesspiece do you want to move? (A7, for example)");
        moveFromColRow = Input.getSelectedPosition();
    }

    public void moveTo() {
        Print.msg("Where do you want to move it? (A7, for example)");
        moveToColRow = Input.getSelectedPosition();
    }
}