package net.woody.pieces;

public class Piece {
    public static final char PAWN_REPRESENTATION = 'p';
    public static final int BLACK_PAWN_RANK = 1;
    public static final int WHITE_PAWN_RANK = 6;

    private Color color;
    private char representation;

    private Piece(String color) {
        this.color = Color.value(color);
        this.representation = this.color.representation(PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK);
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE);
    }

    public static Piece createBlackPawn() {
        return new Piece("");
    }

    public static Piece createWhitePawn() {
        return new Piece("");
    }


    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
