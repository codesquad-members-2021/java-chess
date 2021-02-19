package net.isaac.pieces;

public abstract class Piece {
    public static final char PAWN_REPRESENTATION = 'p';
    public static final char KING_REPRESENTATION = 'k';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char UNKNOWN_REPRESENTATION = '?';

    private final Color color;
    private final char representation;

    Piece(Color color, char representation){
        this.color = color;
        this.representation = representation;
    }

    //Board 출력을 위한 문자 반환
    public char getRepresentation(){
        if(color == Color.BLACK){
            return Character.toUpperCase(representation);
        }
        return representation;
    };

    public Color getColor() {
        return color;
    }

    public static Pawn getPawn(Color color) {
        return new Pawn(color, Piece.PAWN_REPRESENTATION);
    }

    public enum Color {
        BLACK,
        WHITE
    }
}
