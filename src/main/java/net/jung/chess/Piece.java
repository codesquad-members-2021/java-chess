package net.jung.chess;

public class Piece implements Comparable<Piece> {
    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('*', 0.0);

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
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
        return color == Color.WHITE ? type.getWhiteRepresentation() : type.getBlackRepresentation();
    }

    public double getDefaultPoint() {
        return type.defaultPoint;
    }

    private static Piece createWhite(Type type) { return new Piece(Color.WHITE, type); }
    private static Piece createBlack(Type type) { return new Piece(Color.BLACK, type); }

    public static Piece createWhitePawn() { return createWhite(Type.PAWN); }
    public static Piece createBlackPawn() { return createBlack(Type.PAWN); }
    public static Piece createWhiteKnight() { return createWhite(Type.KNIGHT); }
    public static Piece createBlackKnight() { return createBlack(Type.KNIGHT); }
    public static Piece createWhiteRook() { return createWhite(Type.ROOK); }
    public static Piece createBlackRook() { return createBlack(Type.ROOK); }
    public static Piece createWhiteBishop() { return createWhite(Type.BISHOP); }
    public static Piece createBlackBishop() { return createBlack(Type.BISHOP); }
    public static Piece createWhiteQueen() { return createWhite(Type.QUEEN); }
    public static Piece createBlackQueen() { return createBlack(Type.QUEEN); }
    public static Piece createWhiteKing() { return createWhite(Type.KING); }
    public static Piece createBlackKing() { return createBlack(Type.KING); }
    public static Piece createBlank() { return new Piece(Color.NO_COLOR, Type.NO_PIECE); }

    public boolean isWhite() {
        return color == Color.WHITE;
    }
    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isPiece() {
        return getType() != Type.NO_PIECE;
    }

    public boolean isColorType(Color color, Type type) {
        return ((this.color == color) && (this.type == type));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null & obj instanceof Piece) {
            Piece pieceObj = (Piece) obj;
            boolean compareColor = (color == pieceObj.color);
            boolean compareType = (type == pieceObj.type);
            return compareColor && compareType;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return color.hashCode() + type.hashCode();
    }

    @Override
    public int compareTo(Piece piece) {
        if (getDefaultPoint() > piece.getDefaultPoint()) {
            return 1;
        }
        if (getDefaultPoint() < piece.getDefaultPoint()) {
            return -1;
        }
        return 0;
    }

}
