package pieces;

public class Piece {

    private final Color color;
    private final Type type;
    private final char representation;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
        this.representation = 'p';
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public char getRepresentation() {
        return representation;
    }

    public Color getColor() {
        return color;
    }
}
