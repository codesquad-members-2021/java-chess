package chess.domain.pieces;

public class Knight extends Piece {
    private Knight(Color color) {
        super(color);
    }

    @Override
    char getIcon() {
        return 'N';
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public double getScore() {
        return 2.5;
    }

    public static Knight ofWhite() {
        return SingletonHelper.whiteKnight;
    }

    public static Knight ofBlack() {
        return SingletonHelper.blackKnight;
    }

    private static class SingletonHelper {
        private static final Knight whiteKnight = new Knight(Color.WHITE);
        private static final Knight blackKnight = new Knight(Color.BLACK);
    }
}
