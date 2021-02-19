package net.honux.chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';

    private String color;
    private char representation;

    private Piece() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_PAWN_REPRESENTATION;
    }
    public Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public static Piece createWhitePawn() {
        return
    }

    public static Piece createBlackPawn() {
    }
}
