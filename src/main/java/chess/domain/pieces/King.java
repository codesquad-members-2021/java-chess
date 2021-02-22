package chess.domain.pieces;

public class King extends Piece {
    private static final King whiteKing = new King(Color.WHITE);
    private static final King blackKing = new King(Color.BLACK);

    private King(Color color) {
        super(color);
    }

    public static King of(Color color) {
        return color.equals(Color.WHITE)
                ? whiteKing
                : blackKing;
    }

    @Override
    char getIcon() {
        return 'K';
    }
}
