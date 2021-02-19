package mj.chess.pieces;

public class Piece {
    public final static char WHITE_REPRESENTATION = 'p';
    public final static char BLACK_REPRESENTATION = 'P';

    private final Color color;
    private final Type type;
    private final char representation;
    private final RepresentationMap representationMap;

    private Piece(Color color, Type type) {
        representationMap = new RepresentationMap();

        this.color = color;
        this.type = type;
        this.representation = representationMap.getRepresentation(color, type);
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN);
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
