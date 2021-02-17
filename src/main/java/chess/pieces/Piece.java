package chess.pieces;

public class Piece {
    private final Color color;
    private final PieceName name;

    private Piece(Color color, PieceName name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, PieceName.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, PieceName.PAWN);
    }
}

enum PieceName {
    PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING
}


