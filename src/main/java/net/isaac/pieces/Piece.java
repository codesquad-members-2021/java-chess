package net.isaac.pieces;

public class Piece implements Comparable<Piece> {
    private final Color color;
    private final Type type;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    //Board 출력을 위한 문자 반환
    public char getRepresentation() {
        if (color == Color.BLACK) {
            return type.getBlackRepresentation();
        }
        return type.getWhiteRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public static Piece createPiece(Color color, Type type) {
        return new Piece(color, type);
    }

    @Override
    public int compareTo(Piece other) {
        return Double.valueOf(type.defaultPoint).compareTo(other.type.defaultPoint);
    }

    public enum Color {
        BLACK,
        WHITE,
        NOCOLOR,
    }

    public enum Type {
        PAWN('p', 1.0),
        KING('k', 0.0),
        QUEEN('q', 9.0),
        ROOK('r', 5.0),
        BISHOP('b', 3.0),
        KNIGHT('n', 2.5),
        BLANK('.', 0.0);
        private final char representation;
        public final double defaultPoint;

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
}
