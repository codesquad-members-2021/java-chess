package chess.domain.pieces;

public class Bishop extends Piece {
    private Bishop(Color color) {
        super(color);
    }

    @Override
    char getIcon() {
        return 'B';
    }

    @Override
    public double getScore() {
        return 3;
    }

    public static Bishop ofWhite() {
        return SingletonHelper.whiteBishop;
    }

    public static Bishop ofBlack() {
        return SingletonHelper.blackBishop;
    }

    private static class SingletonHelper {
        private static final Bishop whiteBishop = new Bishop(Color.WHITE);
        private static final Bishop blackBishop = new Bishop(Color.BLACK);
    }
}
