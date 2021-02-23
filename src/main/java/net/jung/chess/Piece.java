package net.jung.chess;

public class Piece {
    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }

    public enum Type {
        PAWN('p'),
        KNIGHT('n'),
        ROOK('r'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('*');

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

    private final Color color;
    private final Type type;

    private Piece(Color color, Type type) {
        this.type = type;
        this.color = color;
    }

    public Color getColor() { return color; }

    public Type getType() { return type; }

    public char getRepresentation() {
        return color == Color.WHITE ? type.getWhiteRepresentation() : type.getBlackRepresentation(); }

    private static Piece createWhite(Type type) { return new Piece(Color.WHITE, type); }
    private static Piece createBlack(Type type) { return new Piece(Color.BLACK, type); }

    public static Piece createWhitePawn() { return createWhite(Type.PAWN); }
    public static Piece createBlackPawn() { return createBlack(Type.PAWN); }
    public static Piece createWhiteKnight() { return createWhite(Type.KNIGHT); }
    public static Piece createBlackKnight() {return createBlack(Type.KNIGHT); }
    public static Piece createWhiteRook() { return createWhite(Type.ROOK); }
    public static Piece createBlackRook() { return createBlack(Type.ROOK); }
    public static Piece createWhiteBishop() { return createWhite(Type.BISHOP); }
    public static Piece createBlackBishop() {return createBlack(Type.BISHOP); }
    public static Piece createWhiteQueen() { return createWhite(Type.QUEEN); }
    public static Piece createBlackQueen() { return createBlack(Type.QUEEN); }
    public static Piece createWhiteKing() { return createWhite(Type.KING); }
    public static Piece createBlackKing() {return createBlack(Type.KING); }

    public static Piece createBlank() { return new Piece(Color.NO_COLOR, Type.NO_PIECE);    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }
    public boolean isBlack() {
        return color == Color.BLACK;
    }


}
