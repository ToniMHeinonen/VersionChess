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
}