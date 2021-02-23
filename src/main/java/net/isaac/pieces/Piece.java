package net.isaac.pieces;

public class Piece {
    public static final char PAWN_REPRESENTATION = 'p';
    public static final char KING_REPRESENTATION = 'k';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char KNIGHT_REPRESENTATION = 'n';

    private final Color color;
    private final char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    //Board 출력을 위한 문자 반환
    public char getRepresentation() {
        if (color == Color.BLACK) {
            return Character.toUpperCase(representation);
        }
        return representation;
    }

    ;

    public Color getColor() {
        return color;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public static Piece createPawn(Color color) {
        return new Piece(color, Piece.PAWN_REPRESENTATION);
    }

    public static Piece createKing(Color color) {
        return new Piece(color, Piece.KING_REPRESENTATION);
    }

    public static Piece createQueen(Color color) {
        return new Piece(color, Piece.QUEEN_REPRESENTATION);
    }

    public static Piece createRook(Color color) {
        return new Piece(color, Piece.ROOK_REPRESENTATION);
    }

    public static Piece createBishop(Color color) {
        return new Piece(color, Piece.BISHOP_REPRESENTATION);
    }

    public static Piece createKnight(Color color) {
        return new Piece(color, Piece.KNIGHT_REPRESENTATION);
    }

    public enum Color {
        BLACK,
        WHITE
    }
}
