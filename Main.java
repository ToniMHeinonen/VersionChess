public class Main {

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("*********************************");
        System.out.println("*    Welcome to play Chess!     *");
        System.out.println("*    1.   Play the game         *");
        System.out.println("*    2.    Information          *");
        System.out.println("*    3.        Quit             *");
        System.out.println("*********************************");
        System.out.println("Please select one of the options (1-3): ");
        choice = Input.getInt(1, 3, "Invalid input! Choose one of the three options.");

        switch (choice) {

            case 1: {
                Board chess = new Board();
                chess.play();
            }

            case 2: {

                break;
            }

            case 3: {
                System.exit(0);
            }
        }
    }
}
