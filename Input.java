import java.util.Scanner;

public abstract class Input {
    Scanner input = new Scanner(System.in);

    public String getString() {
        String str = "";

        while (true) {
            str = input.nextLine();

            if (str.equals("") || str.startsWith(" ")) {
                // Print error
            } else {
                break;
            }
        }

        return str;
    }
}