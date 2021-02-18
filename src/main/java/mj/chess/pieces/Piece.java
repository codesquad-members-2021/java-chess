package mj.chess.pieces;

final class Piece {
    public final static char WHITE_REPRESENTATION = 'p';
    public final static char BLACK_REPRESENTATION = 'P';

    private final Color color;
    private final char representation;
    private final Type type;

    public Piece(Color color, Type type, char representation) {
        this.color = color;
        this.type = type;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN, WHITE_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN, BLACK_REPRESENTATION);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return representation;
    }
}
