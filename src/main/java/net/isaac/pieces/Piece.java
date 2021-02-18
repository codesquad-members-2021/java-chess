package net.isaac.pieces;

public abstract class Piece {
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char UNKNOWN_REPRESENTATION = '?';

    private Color color;
    private char representation;

    public Piece(Color color, char representation){
        this.color = color;
        this.representation = representation;
    }

    //Board 출력을 위한 문자 반환
    public char getRepresentation(){
        return representation;
    };

    public Color getColor() {
        return color;
    }

    public enum Color {
        BLACK,
        WHITE
    }
}
