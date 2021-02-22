package chess.pieces;

public class Piece {
    private final Type type;
    private final Color color;

    private Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public static Piece createWhitePawn() {
        return new Piece(Piece.Type.PAWN, Piece.Color.WHITE);
    }

    public static Piece createBlackPawn() {
        return new Piece(Piece.Type.PAWN, Piece.Color.BLACK);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Piece.Type.KNIGHT, Piece.Color.WHITE);
    }

    public static Piece createBlackKnight() {
        return new Piece(Piece.Type.KNIGHT, Piece.Color.BLACK);
    }

    public static Piece createWhiteRook() {
        return new Piece(Piece.Type.ROOK, Piece.Color.WHITE);
    }

    public static Piece createBlackRook() {
        return new Piece(Piece.Type.ROOK, Piece.Color.BLACK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Piece.Type.BISHOP, Piece.Color.WHITE);
    }

    public static Piece createBlackBishop() {
        return new Piece(Piece.Type.BISHOP, Piece.Color.BLACK);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Piece.Type.QUEEN, Piece.Color.WHITE);
    }

    public static Piece createBlackQueen() {
        return new Piece(Piece.Type.QUEEN, Piece.Color.BLACK);
    }

    public static Piece createWhiteKing() {
        return new Piece(Piece.Type.KING, Piece.Color.WHITE);
    }

    public static Piece createBlackKing() {
        return new Piece(Piece.Type.KING, Piece.Color.BLACK);
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

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }
    }
}
