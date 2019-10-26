public abstract class Print {

    /**
     * Prints startScreen for player.
     */
    public static void startScreen() {
        System.out.println("*********************************");
        System.out.println("*    Welcome to play Chess!     *");
        System.out.println("*    1.   Play the game         *");
        System.out.println("*    2.    Information          *");
        System.out.println("*    3.        Quit             *");
        System.out.println("*    4.     Tic-Tac-Toe         *");
        System.out.println("*********************************");
        System.out.println("Please select one of the options (1-3):");
    }
    
    /** 
     * Prints provided text surrounded by borders.
     * @param text to print
     */
    public static void msg(String text) {
        String border = "---";
        System.out.println(border + " " + text + " " + border);
    }

    /**
     * Prints provided error text surrounded by borders.
     * @param text to print
     */
    public static void error(String text) {
        String border = "!!!";
        System.out.println(border + " " + text + " " + border);
    }

    /**
     * Prints the board.
     * @param positions positions of chesspieces
     */
    public static void board(ChessPiece[][] positions) {
        System.out.println("   A B C D E F G H");
        System.out.println("  _________________");
        
        for (int row = positions.length-1; row >= 0; row--) {
            System.out.print((row+1) + " ");    // Print row number

            for (int col = 0; col < positions[row].length; col++) {
                System.out.print("|");
                String slot;
                ChessPiece p = positions[row][col];

                if (p == null)
                    slot = " ";
                else
                    slot = p.toString();

                System.out.print(slot);
            }

            System.out.println("|");
        }
        
        // Print overline on the bottom
        String o = "\u203E";
        System.out.print("  "); //  Print space before overline
        for (int i = 0; i < 17; i++)
            System.out.print(o);
        
        System.out.println();
    }

    /**
     * Prints information about rules/chess/how to play
     */
    public static void information() {
        System.out.println("Information about chess.");
        Input.waitForEnter("Press enter to continue");
    }

    public static void ticTacToeBoard(String[][] TTTBoard) {
        System.out.println("   A B C");
        System.out.println("  ________");

        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + "  ");
            for (int j = 0; j < 3; j++) {
                String output;
                if (TTTBoard[i][j] == null) {
                    output = " ";
                } else {
                    output = TTTBoard[i][j];
                }
                System.out.print(output + " ");
            }
            System.out.println();
        }
    }
}