public abstract class Helper {
    
    public static ChessPiece[][] copyPositions(ChessPiece[][] positions) {
        ChessPiece[][] copy = new ChessPiece[positions.length][positions.length];
        System.arraycopy(positions, 0, copy, 0, copy.length);
        return copy;
    }

    public static boolean isFree(ChessPiece[][] positions) {
        
    }
}