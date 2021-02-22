package chess.domain.pieces;

public class Knight extends Piece {
    private static final Knight whiteKnight = new Knight(Color.WHITE);
    private static final Knight blackKnight = new Knight(Color.BLACK);

    private Knight(Color color) {
        super(color);
    }

    public static Knight of(Color color) {
        return color.equals(Color.WHITE)
                ? whiteKnight
                : blackKnight;
    }

    @Override
    char getIcon() {
        return 'N';
    }
}
