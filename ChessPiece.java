public class ChessPiece {
	private int row, col;
	private Player player;
	private String symbol;
	public static final String P1COLOR = "\u001B[34m"; // Blue
	public static final String P2COLOR = "\u001B[31m"; // Red
	public static final String RESET_COLOR = "\u001B[0m"; // Reset back to default

	public ChessPiece(int row, int col, Player player) {
		this.row = row;
		this.col = col;
		this.player = player;
	}

	/**
	 * Get symbol of the chesspiece.
	 * 
	 * @return symbol of the chesspiece
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Set symbol of the chesspiece.
	 * 
	 * @param symbol symbol of the chesspiece
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Get row of the chesspiece.
	 * 
	 * @return row of the chesspiece
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Set row of the chesspiece.
	 * 
	 * @param row row of the chesspiece
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Get column of the chesspiece.
	 * 
	 * @return column of the chesspiece
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Set column of the chesspiece.
	 * 
	 * @param col column of the chesspiece
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Get player 1 or 2.
	 * 
	 * @return player 1 or 2
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Set player 1 or 2.
	 * 
	 * @param player player 1 or 2
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Returns color of the symbol in blue for player 1
	 * and red for AI/player 2. Then it changes text back to default.
	 */
	public String toString() {
		if (this.player.getNumber() == 1) {
			return P1COLOR + symbol + RESET_COLOR;
		} else {
			return P2COLOR + symbol + RESET_COLOR;
		}
	}
}