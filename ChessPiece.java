public class ChessPiece {
	private int x, y;
	private int player;
	private String symbol;

	public ChessPiece(int x, int y, int player) {
		this.x = x;
		this.y = y;
		this.player = player;
	}

    public int getX() {
        return x;
    }

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}