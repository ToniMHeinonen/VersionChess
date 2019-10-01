public class ChessPiece {
	private int row, col;
	private int player;
	private String symbol;

	public ChessPiece(int row, int col, int player) {
		this.row = row;
		this.col = col;
		this.player = player;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

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
}