package mj.chess.pieces;

public class Piece {

    private final Color color;
    private final Type type;
    private final char representation;

    private Piece(Color color, Type type) {
        RepresentationMap representationMap = new RepresentationMap();

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
