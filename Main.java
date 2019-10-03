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
        boolean choices = true;
        while (choices) {
            choice = Helpers.inputInt();
            if (choice > 3 || choice < 1) {
                System.out.println("Invalid input! Choose one of the three options.");
            } else {
                choices = false;
            }
        }
        switch (choice) {

            case 1: {
                Board chess = new Board();
                chess.play();
            }

            case 2: {
                System.out.println("           OBJECTIVE               ");
                System.out.println("    Objective is to checkmate your ");
                System.out.println("    opponent's King.               ");
                System.out.println("    When a King cannot avoid  and  ");
                System.out.println("    capture then it is checkmated  ");
                System.out.println("    the game is immediately over.  ");

                break;
            }

            case 3: {
                System.exit(0);
            }
        }
    }
}
