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
    public static int[] getMoveFrom() {
        String str = "";
        int col;
        int row;
        int[] moveFrom = new int[2];

        while(true) {
            str = input.nextLine();
            col = Character.getNumericValue(str.charAt(0)) - 9;
            row = Character.getNumericValue(str.charAt(1));

            if (str.length() > 2 || str.length() < 1 || col > 7 || col < 1 || row > 7 || row < 1) {
                Print.error("Give valid value.");
            } else {
                break;
            }
        }

        moveFrom[0] = col;
        moveFrom[1] = row;
        return moveFrom;
    }
}