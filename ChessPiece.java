public class ChessPiece {
	private int row, col;
	private int player;
	private String symbol;

	public ChessPiece(int row, int col, int player) {
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
	 * Get row of the board.
	 * 
	 * @return row of the board
	 */
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}
}