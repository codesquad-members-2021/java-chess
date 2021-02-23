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
        NO_PIECE(' ');

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

    public static Piece createWhitePawn() { return new Piece(Color.WHITE, Type.PAWN); }
    public static Piece createBlackPawn() { return new Piece(Color.BLACK, Type.PAWN); }
    public static Piece createWhiteKnight() { return new Piece(Color.WHITE, Type.KNIGHT); }
    public static Piece createBlackKnight() { return new Piece(Color.BLACK, Type.KNIGHT); }
    public static Piece createWhiteRook() { return new Piece(Color.WHITE, Type.ROOK); }
    public static Piece createBlackRook() { return new Piece(Color.BLACK, Type.ROOK); }
    public static Piece createWhiteBishop() { return new Piece(Color.WHITE, Type.BISHOP); }
    public static Piece createBlackBishop() { return new Piece(Color.BLACK, Type.BISHOP); }
    public static Piece createWhiteQueen() { return new Piece(Color.WHITE, Type.QUEEN); }
    public static Piece createBlackQueen() { return new Piece(Color.BLACK, Type.QUEEN); }
    public static Piece createWhiteKing() { return new Piece(Color.WHITE, Type.KING); }
    public static Piece createBlackKing() { return new Piece(Color.BLACK, Type.KING); }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }


}
