public class Main {

    public static void main(String[] args) {
        while (true) {
            Print.startScreen();
            int choice = Input.getInt(1, 3, "Invalid input! Choose one of the three options.");

            switch (choice) {

                case 1: {
                    Board chess = new Board();
                    chess.play();
                    break;
                }

                case 2: {
                    Print.information();
                    break;
                }

                case 3: {
                    System.exit(0);
                }

                case 4: {
                    TicTacToe tictactoe = new TicTacToe();
                    break;
                }
            }
        }
    }
}
