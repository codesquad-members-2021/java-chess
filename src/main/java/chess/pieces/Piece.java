package chess.pieces;

import java.util.Objects;

public class Piece {
    private final Color color;
    private final Type type;
    private final char representation;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
        this.representation = createRepresentation(color, type);
    }

    public char createRepresentation(Color color, Type name) {
        if (color == Color.WHITE) {
            return name.getWhiteRepresentation();
        }
        return name.getBlackRepresentation();
    }

    public Color getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }

    public Type getType() {
        return this.type;
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1),
        KNIGHT('n', 2.5),
        ROOK('r', 5),
        BISHOP('b', 3),
        QUEEN('q', 9),
        KING('k', 0),
        NO_PIECE('.', 0);

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double point) {
            this.representation = representation;
            this.defaultPoint = point;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }
}


