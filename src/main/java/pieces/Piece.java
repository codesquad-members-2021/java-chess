package pieces;

public class Piece {
    private final Color color;
    private final Type type;

    public enum Color {
        WHITE, BLACK;
    }

    public enum Type {
        PAWN('p'),
        KNIGHT('n'),
        ROOK('r'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k');

        private final char representation;

        Type(final char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }
    }

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        if (color == Color.WHITE) {
            return type.getWhiteRepresentation();
        }
        return type.getBlackRepresentation();
    }
}

