package chess.pieces;

public class Piece {
    private final Type type;
    private final Color color;

    private Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public static Piece createWhite(Type type) {
        return new Piece(type, Piece.Color.WHITE);
    }

    public static Piece createBlack(Type type) {
        return new Piece(type, Piece.Color.BLACK);
    }

    public static Piece createBlank() {
        return new Piece(Type.NO_PIECE, Piece.Color.NO_COLOR);
    }
    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }

    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getRepresentation() {
            return representation;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }
    }
}
