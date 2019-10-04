public abstract class Print {
    
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

    public static void board(ChessPiece[] positions) {
        
    }
}