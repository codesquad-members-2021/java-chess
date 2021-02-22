package chess.domain.pieces;

public class Knight extends Piece {
    private static final Knight whiteKnight = new Knight(Color.WHITE);
    private static final Knight blackKnight = new Knight(Color.BLACK);

    private Knight(Color color) {
        super(color);
    }

    public static Knight ofWhite() {
        return whiteKnight;
    }

    public static Knight ofBlack() {
        return blackKnight;
    }

    @Override
    char getIcon() {
        return 'N';
    }
}
