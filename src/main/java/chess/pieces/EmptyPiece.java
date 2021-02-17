package chess.pieces;

public class EmptyPiece extends Piece {
    private EmptyPiece() {
        super(".");
    }

    public static EmptyPiece getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final EmptyPiece instance = new EmptyPiece();
    }
}
