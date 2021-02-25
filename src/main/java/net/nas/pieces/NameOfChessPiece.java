package net.nas.pieces;

public enum NameOfChessPiece {
    PAWN("P", 1),
    ROOK("R", 5),
    KNIGHT("N", 2.5f),
    BISHOP("B", 3),
    QUEEN("Q", 9),
    KING("K", 0),
    NO_PIECE(".", 0);

    private final String representation;
    public static final float SCORE_OF_SPECIAL_PAWN = 0.5f;
    private final float point;

    NameOfChessPiece(String representation, float point) {
        this.representation = representation;
        this.point = point;
    }

    public String getRepresentation() {
        return representation;
    }

    public float getPoint() {
        return point;
    }

    public static NameOfChessPiece getNameByRepresentation(String representation) {
        representation = representation.toUpperCase();
        for (NameOfChessPiece name : NameOfChessPiece.values()) {
            if (name.representation.equals(representation)) {
                return name;
            }
        }
        return NO_PIECE;
    }
}
