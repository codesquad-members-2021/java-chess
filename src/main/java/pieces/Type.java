package pieces;

public enum Type {
    PAWN    ('p', 1.0),
    KNIGHT  ('n', 2.5),
    ROOK    ('r', 5.0),
    BISHOP  ('b', 3.0),
    QUEEN   ('q', 9.0),
    KING    ('k', 0.0),
    NO_PIECE('.', 0.0);

    private final char representation;
    private final double point;

    Type(char representation, double point) {
        this.representation = representation;
        this.point = point;
    }

    public char getRepresentation(Color color) {
        char representation = '.';
        if (color == Color.BLACK) {
            representation = Character.toUpperCase(this.representation);
        }
        if (color == Color.WHITE) {
            representation = Character.toLowerCase(this.representation);
        }
        return representation;
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
