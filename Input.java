import java.util.Scanner;

public abstract class Input {
    private static Scanner input = new Scanner(System.in);

    public static String getString() {
        String str = "";

        while (true) {
            str = input.nextLine();

            if (str.equals("") || str.startsWith(" ")) {
                Print.error("Name not allowed");
            } else {
                break;
            }
        }

        return str;
    }

    public static int getInt(int min, int max, String error) {
        int number;

        if (error == null)
            error = "Number not allowed";

        while (true) {
            number = input.nextInt();

            if (number >= min && number <= max) {
                break;
            } else {
                Print.error(error);
            }
        }

        // Catch the newline generated from input.nextInt()
        input.nextLine();

        return number;
    }

    public static void waitForEnter(String msg) {
        if (msg != null)
            Print.msg(msg);
        
        input.nextLine();
    }

    /**
     * Get position of the chesspiece that players wants to move.
     * (Currently program crashes, if you give values that are 0 or 1
     * characters long.)
     * 
     * @return position of the chesspiece that players wants to move
     */
    public static int[] getSelectedPosition() {
        String str = "";
        int col = 0;
        int row = 0;
        int[] moveFrom = new int[2];

        while(true) {
            str = input.nextLine();

            if(str.length() > 2 || str.length() <= 1) {
                Print.error("Give valid value.");
            } else {
                col = Character.getNumericValue(str.charAt(0)) - 9;
                row = Character.getNumericValue(str.charAt(1));
            }

            if (col > 8 || col < 1 || row > 8 || row < 1) {
                Print.error("Out of bounds.");
            } else {
                break;
            }
        }

        // Decrease values by 1 since arrays use values 0-7 and player 1-8
        moveFrom[0] = row-1;
        moveFrom[1] = col-1;
        // moveFrom[0] = row of the piece that player wants to move.
        // moveFrom[1] = column of the piece that player wants to move.
        return moveFrom;
    }
}