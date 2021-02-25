package chess.domain.pieces;

public class NoPiece extends Piece {
    private NoPiece() {
        super(Color.NOCOLOR);
    }

    @Override
    char getIcon() {
        return '.';
    }

    @Override
    public double getScore() {
        return 0;
    }

    public static NoPiece getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final NoPiece instance = new NoPiece();
    }
}
