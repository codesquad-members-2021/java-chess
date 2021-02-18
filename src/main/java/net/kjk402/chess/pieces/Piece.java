package net.kjk402.chess.pieces;

public class Piece {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    private final String color;
    private final char representation;

    public Piece() {
        this.color = WHITE;
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
        return new Piece(WHITE, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, BLACK_PAWN_REPRESENTATION);
    }

}
