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

    /**
     * Add chesspiece to arraylist.
     * @param piece chesspiece to add
     */
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

    /**
     * Set player's number
     * @param number player's number
     */
	public void setNumber(int number) {
		this.number = number;
	}

    /**
     * Get player's king-piece.
     * @return player's king-piece
     */
    public ChessPiece getKing() {
        return king;
    }

    /**
     * Set player's king-piece.
     * @param king player's king-piece
     */
    public void setKing(ChessPiece king) {
        this.king = king;
    }

    /**
     * Get chesspieces.
     * @return chesspieces
     */
    public ArrayList<ChessPiece> getPieces() {
        return pieces;
    } 
}