public abstract class ChessPiece {
	private int row, col;
	private Player player;
	private String symbol;

	public ChessPiece(int row, int col, Player player) {
		this.row = row;
		this.col = col;
		this.player = player;
	}

	public abstract boolean eat();

	public abstract boolean canMove();

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

	public String toString() {
		return symbol;
	}
}