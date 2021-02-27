package chess.domain.pieces;

public class Pawn extends Piece {
    private Pawn(Color color) {
        super(color);
    }

    @Override
    char getIcon() {
        return 'P';
    }

    @Override
    public boolean isPawn() {
        return true;
    }

    @Override
    public double getScore() {
        return 1;
    }

    public static Pawn ofWhite() {
        return SingletonHelper.whitePawn;
    }

    public static Pawn ofBlack() {
        return SingletonHelper.blackPawn;
    }

    private static class SingletonHelper {
        private static final Pawn whitePawn = new Pawn(Color.WHITE);
        private static final Pawn blackPawn = new Pawn(Color.BLACK);
    }
}
