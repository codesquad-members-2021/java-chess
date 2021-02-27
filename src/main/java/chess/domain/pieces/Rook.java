package chess.domain.pieces;

public class Rook extends Piece {
    private Rook(Color color) {
        super(color);
    }

    @Override
    char getIcon() {
        return 'R';
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public double getScore() {
        return 5;
    }

    public static Rook ofWhite() {
        return SingletonHelper.whiteRook;
    }

    public static Rook ofBlack() {
        return SingletonHelper.blackRook;
    }

    private static class SingletonHelper {
        private static final Rook whiteRook = new Rook(Color.WHITE);
        private static final Rook blackRook = new Rook(Color.BLACK);
    }
}
