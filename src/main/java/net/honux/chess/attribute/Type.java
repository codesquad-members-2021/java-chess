package net.honux.chess.attribute;

public enum Type {
    PAWN('p', 1), ROOK('r', 5), KNIGHT('n', 2.5),
    BISHOP('b', 3), QUEEN('q', 9), KING('k', 0), NO_PIECE('.', 0);

    private final char representation;
    private final double point;

    Type(char representation, double point) {
        this.representation = representation;
        this.point = point;
    }

    public char getRepresentation(Color color) {
        if (color == Color.BLACK) {
            return Character.toUpperCase(representation);
        }
        return representation;
    }

    public double getPoint() {
        return point;
    }
}
