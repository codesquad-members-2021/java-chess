package pieces;

public enum Type {
    PAWN  ('p'),
    KNIGHT('n'),
    ROOK  ('r'),
    BISHOP('b'),
    QUEEN ('q'),
    KING  ('k');

    private final char representation;

    Type(char representation) {
        this.representation = representation;
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
}
