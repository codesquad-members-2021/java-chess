package chess.domain.pieces;

public class Bishop extends Piece {
    private static final Bishop whiteBishop = new Bishop(Color.WHITE);
    private static final Bishop blackBishop = new Bishop(Color.BLACK);

    private Bishop(Color color) {
        super(color);
    }

    public static Bishop of(Color color) {
        return color.equals(Color.WHITE)
                ? whiteBishop
                : blackBishop;
    }

    @Override
    char getIcon() {
        return 'B';
    }
}
