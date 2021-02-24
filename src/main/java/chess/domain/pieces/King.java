package chess.domain.pieces;

public class King extends Piece {
    private King(Color color) {
        super(color);
    }

    @Override
    char getIcon() {
        return 'K';
    }

    public static King ofWhite() {
        return SingletonHelper.whiteKing;
    }

    public static King ofBlack() {
        return SingletonHelper.blackKing;
    }

    private static class SingletonHelper {
        private static final King whiteKing = new King(Color.WHITE);
        private static final King blackKing = new King(Color.BLACK);
    }
}
