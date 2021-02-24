package net.sky.pieces;

public enum PieceType {
    PAWN('p', 1.0),
    KNIGHT('n', 2.5),
    ROOK('r', 5.0),
    BISHOP('b', 3.0),
    QUEEN('q', 9.0),
    KING('k', 0.0),
    NO_PIECE('.', 0.0);


    private final char representation;
    private final double point;

    PieceType(char representation, double point) {
        this.representation = representation;
        this.point = point;
    }

    public char getRepresentation() {
        return representation;
    }

    public double getPoint() {
        return point;
    }
}
