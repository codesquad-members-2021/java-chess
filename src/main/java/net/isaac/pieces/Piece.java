package net.isaac.pieces;

public class Piece {
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

    public enum Color {
        BLACK,
        WHITE,
        NOCOLOR,
    }

    public enum Type {
        PAWN('p'), KING('k'), QUEEN('q'), ROOK('r'),
        BISHOP('b'), KNIGHT('n'), BLANK('.');
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
}
