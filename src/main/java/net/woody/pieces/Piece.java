package net.woody.pieces;

public class Piece {
    public static final char PAWN_REPRESENTATION = 'p';
    public static final int BLACK_PAWN_RANK = 1;
    public static final int WHITE_PAWN_RANK = 6;

    private Color color;
    private char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = color.representation(representation);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, PAWN_REPRESENTATION);
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, PAWN_REPRESENTATION);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
