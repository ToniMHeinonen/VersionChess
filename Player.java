import java.util.ArrayList;

public class Player {

    /**
     * If a player, holds the name of player.
     */
    private String name;

    private int number;

    private ArrayList<ChessPiece> pieces = new ArrayList<>();

    /**
     * Used to determine if player is a bot
     */
    boolean bot;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;

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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}