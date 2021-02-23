package pieces;

public enum Type {
    NO_PIECE('.', 0.0),
    KING    ('k', 0.0),
    PAWN    ('p', 1.0),
    KNIGHT  ('n', 2.5),
    BISHOP  ('b', 3.0),
    ROOK    ('r', 5.0),
    QUEEN   ('q', 9.0);

    private final char representation;
    private final double point;

    Type(char representation, double point) {
        this.representation = representation;
        this.point = point;
    }

    public char getWhiteRepresentation() {
        return representation;
    }

    public char getBlackRepresentation() {
        return Character.toUpperCase(representation);
    }

    public double getPoint() {
        return point;
    }
}
