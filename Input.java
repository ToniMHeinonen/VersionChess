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

    public static int getInt(int min, int max) {
        
    }
}