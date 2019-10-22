public class Board {

    private ChessPiece[][] positions = new ChessPiece[8][8];
    private Player[] players = new Player[2];
    private Player playerTurn;
    private ChessPiece selectedPiece;
    private int state;
    private final int MOVE_FROM = 0, MOVE_TO = 1, MOVING = 2, NEXT_TURN = 3;
    /*
    moveFromColRow[] contains two values: column and row.
    These values are the chesspiece's position, which
    player wants to move.
    */
    private int[] moveFromColRow, moveToColRow;

    /**
     * Calls initializeChess method.
     * 
     * Method adds chess pieces and players.
     */
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

            // Add pieces to the player
            for (int i = 0; i < positions[row].length; i++) {
                p.addPiece(positions[row][i]);
                p.addPiece(positions[pawnRow][i]);
            }
            p.setKing(positions[row][4]);
        }   
    }

    /**
     * Get names for players and initialize them to the players array.
     */
    private void initializePlayers() {
        Print.msg("Give name to player 1:");
        players[0] = new Player(Input.getString(), 1);
        Print.msg("Give name to player 2:");
        players[1] = new Player(Input.getString(), 2);
        playerTurn = players[0];
    }

    public void play() {
        while (true) {
            if (state == MOVE_FROM)
                moveFrom();
            if (state == MOVE_TO)
                moveTo();
            if (state == MOVING)
                movePiece();
            if (state == NEXT_TURN)
                nextTurn();
        }
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
    private void nextTurn() {
        if (playerTurn == players[0])
            playerTurn = players[1];
        else
            playerTurn = players[0];

        state = MOVE_FROM;
    }

    /**
     * Get position of the chesspiece that players wants to move.
     */
    private void moveFrom() {
        Print.board(positions);

        // Print check message if check is on
        if (playerTurn.isCheckIsOn())
            Print.msg("Check");

        Print.msg(playerTurn.getName() + 
            ", which chesspiece do you want to move? (A7, for example)");
        
        while (true) { 
            moveFromColRow = Input.getSelectedPosition();
            int row = moveFromColRow[0];
            int col = moveFromColRow[1];
            selectedPiece = positions[row][col];

            if (selectedPiece == null) {
                Print.error("Position is empty");
            } else if (selectedPiece.getPlayer() == playerTurn) {
                state = MOVE_TO;
                break;
            } else if (selectedPiece.getPlayer() != playerTurn) {
                Print.error("That is not your chess piece");
            }
        }
    }

    /**
     * Move chess piece to the desired position if able.
     */
    private void moveTo() {
        Print.msg("Where do you want to move it? (A7, for example)");
        
        while (true) {
            moveToColRow = Input.getSelectedPosition();
            int row = moveToColRow[0];
            int col = moveToColRow[1];

            ChessPiece position = positions[row][col];

            /* If player chose same spot twice, return back to selecting
            which piece to move */
            if (moveFromColRow.equals(moveToColRow)) {
                state = MOVE_FROM;
                break;
            }

            /* If selected position is null or occupied by the opponent, check
            if the piece can move to the spot or not */
            if (position == null || position.getPlayer() != playerTurn) {
                if (selectedPiece.canMove(row,col,positions)) {
                    state = MOVING;
                    break;
                } else {
                    Print.error("Piece can't move there");
                }
            } else {
                Print.error("Position already occupied");
            }
        }
    }

    /**
     * Move selected piece to new position, if piece lands on a 
     * space occupied by opponent's piece, the piece is automatically
     * "eaten".
     */
    private void movePiece() {
        int fromRow = moveFromColRow[0];
        int fromCol = moveFromColRow[1];
        int toRow = moveToColRow[0];
        int toCol = moveToColRow[1];
        // Create copy of positions so we can reset the positions if move is illegal.
        ChessPiece[][] copy = Helper.copyPositions(positions);

        // Move piece to the new position
        positions[fromRow][fromCol] = null;
        positions[toRow][toCol] = selectedPiece;

        // If move is legal, set piece's row and col
        if (lookForCheck()) {
            selectedPiece.setRow(toRow);
            selectedPiece.setCol(toCol);
            state = NEXT_TURN;
        } else {
            positions = copy;
            state = MOVE_FROM;
        }
    }

    /**
     * Checks if player's move causes check to himself or to the opponent.
     * 
     * If move is legal, return true. Else return false.
     * 
     * @return if move is legal
     */
    private boolean lookForCheck() {
        for (Player p : players) {
            Player opponent;
            if (p.equals(players[0]))
                opponent = players[1];
            else
                opponent = players[0];

            ChessPiece opponentKing = opponent.getKing();

            for (ChessPiece c : p.getPieces()) {
                int row = opponentKing.getRow();
                int col = opponentKing.getCol();
                if (c.canMove(row, col, positions)) {
                    // If player's move causes check for opponent
                    if (p.equals(playerTurn)) {
                        opponent.setCheckIsOn(true);
                        break;
                    } 
                    // If player's move causes check for himself,
                    // return false and print error
                    else {
                        Print.error("Move causes check for you");
                        opponent.setCheckIsOn(false);
                        state = MOVE_FROM;
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isCheckMate() {
        ChessPiece king = playerTurn.getKing();
    }

    /**
     * Removes symbol of opponents piece from the board.
     */
    public void eatPiece() {
        int row = moveToColRow[0];
        int col = moveToColRow[1];

        ChessPiece position = positions[row][col];

        if (position == !null; && selectedPiece.getPlayer() !=playerTurn ) {
        }
    }
}