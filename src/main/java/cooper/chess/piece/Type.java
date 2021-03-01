package cooper.chess.piece;

public enum Type {
    PAWN('p', 1.0),
    KNIGHT('n', 2.5),
    ROOK('r', 5.0),
    BISHOP('b', 3.0),
    QUEEN('q', 9.0),
    KING('k', 0.0),
    NO_PIECE('.', 0.0);

    private final Character representation;
    private final double defaultPoint;

    Type(Character representation, double defaultPoint) {
        this.representation = representation;
        this.defaultPoint = defaultPoint;
    }

    public char getRepresentaion(Color color) {
        if (color == Color.WHITE) {
            return Character.toUpperCase(representation);
        }

        if (color == Color.BLACK) {
            return representation;
        }

        return NO_PIECE.representation;
    }

    public double getDefaultPoint() {
        return defaultPoint;
    }

}
