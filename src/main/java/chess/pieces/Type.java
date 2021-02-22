package chess.pieces;

public enum Type {
    PAWN('p'),
    ROOK('r'),
    KNIGHT('n'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k');

    private final char representation;

    Type(char representation) {
        this.representation = representation;
    }

    public char getWhiteRepresentation() {
        return representation;
    }

    public char getBlackRepresentation() {
        return Character.toUpperCase(representation);
    }
}
