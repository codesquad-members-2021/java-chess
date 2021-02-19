package chess.domain.pieces;

public class Pawn extends Piece {
    private static final Pawn whitePawn = new Pawn(Color.WHITE);
    private static final Pawn blackPawn = new Pawn(Color.BLACK);

    private Pawn(Color color) {
        super(color);
    }

    public static Piece of(Color color) {
        return color.equals(Color.WHITE)
                ? whitePawn
                : blackPawn;
    }

    @Override
    String getIcon() {
        return "P";
    }
}
