package chess.domain.pieces;

public class Pawn extends Piece {
    private static final Pawn whitePawn = new Pawn(Color.WHITE);
    private static final Pawn blackPawn = new Pawn(Color.BLACK);

    private Pawn(Color color) {
        super(color);
    }

    public static Pawn ofWhite() {
        return whitePawn;
    }

    public static Pawn ofBlack() {
        return blackPawn;
    }

    @Override
    char getIcon() {
        return 'P';
    }
}
