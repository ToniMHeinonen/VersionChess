import java.util.ArrayList;

public class Player {

    /**
     * If a player, holds the name of player.
     */
    private String name;

    private int number;

    private ArrayList<ChessPiece> pieces = new ArrayList<>();
    private ChessPiece king;

    /**
     * Used to determine if player is a bot
     */
    boolean bot;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;

    }

    public void addPiece(ChessPiece piece) {
        pieces.add(piece);
    }

    /**
     * Get player's name.
     * @return player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set player's name.
     * @param name player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get player's number.
     * @return player's number
     */
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

    public ChessPiece getKing() {
        return king;
    }

    public void setKing(ChessPiece king) {
        this.king = king;
    }

    public ArrayList<ChessPiece> getPieces() {
        return pieces;
    } 
}