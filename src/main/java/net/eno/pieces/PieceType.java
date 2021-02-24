package net.eno.pieces;

public enum PieceType {

    PAWN('p', 1.0),
    ROOK('r', 5.0),
    KNIGHT('n', 2.5),
    BISHOP('b', 3.0),
    QUEEN('q', 9.0),
    KING('k', 0.0),
    NO_PIECE('.', 0.0);

    private final char representation;
    private final double defaultPoint;

    PieceType(char representation, double defaultPoint) {
        this.representation = representation;
        this.defaultPoint = defaultPoint;
    }

    public char getRepresentation(Color color) {
        return color == Color.BLACK ?
                Character.toUpperCase(this.representation) :
                this.representation;
    }

    public double getDefaultPoint() {
        return defaultPoint;
    }

}
