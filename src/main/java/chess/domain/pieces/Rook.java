package chess.domain.pieces;

public class Rook extends Piece {
    private static final Rook whiteRook = new Rook(Color.WHITE);
    private static final Rook blackRook = new Rook(Color.BLACK);

    private Rook(Color color) {
        super(color);
    }

    public static Rook of(Color color) {
        return color.equals(Color.WHITE)
                ? whiteRook
                : blackRook;
    }

    @Override
    char getIcon() {
        return 'R';
    }
}
