package chess.domain.pieces;

public class EmptyPiece extends Piece {
    private EmptyPiece() {
        super(Color.WHITE);
    }

    @Override
    String getIcon() {
        return ".";
    }

    public static EmptyPiece getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final EmptyPiece instance = new EmptyPiece();
    }
}
