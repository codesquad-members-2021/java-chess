package chess.domain.pieces;

public class Queen extends Piece {
    private Queen(Color color) {
        super(color);
    }

    @Override
    char getIcon() {
        return 'Q';
    }

    @Override
    public double getScore() {
        return 9;
    }

    public static Queen ofWhite() {
        return SingletonHelper.whiteQueen;
    }

    public static Queen ofBlack() {
        return SingletonHelper.blackQueen;
    }

    private static class SingletonHelper {
        private static final Queen whiteQueen = new Queen(Color.WHITE);
        private static final Queen blackQueen = new Queen(Color.BLACK);
    }
}
