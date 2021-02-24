package piece.attribute;

public enum Type {
    PAWN('p', 1.0),
    ROOK('r', 5.0),
    KNIGHT('n', 2.5),
    BISHOP('b', 3.0),
    QUEEN('q', 9.0),
    KING('k', 0.0),
    BLANK('.', 0.0);

    private final char representation;
    private final double defaultPoint;

    Type(final char representation, final double defaultPoint) {
        this.representation = representation;
        this.defaultPoint = defaultPoint;
    }

    public double getDefaultPoint() {
        return defaultPoint;
    }

    public char getWhiteRepresentation() {
        return representation;
    }

    public char getBlackRepresentation() {
        return Character.toUpperCase(representation);
    }
}

