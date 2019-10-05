public abstract class Print {
    
    public static void startScreen() {
        System.out.println("*********************************");
        System.out.println("*    Welcome to play Chess!     *");
        System.out.println("*    1.   Play the game         *");
        System.out.println("*    2.    Information          *");
        System.out.println("*    3.        Quit             *");
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

    public static void error(String text) {
        String border = "!!!";
        System.out.println(border + " " + text + " " + border);
    }

    public static void board(ChessPiece[][] positions) {
        System.out.println("_________________");
        
        for (int row = 0; row < positions.length; row++) {
            
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
}