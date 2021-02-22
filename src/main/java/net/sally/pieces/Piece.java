package net.sally.pieces;

public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';

    private final String color;
    private final char representation;

    public Pawn() {
        this.color = WHITE;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isWhite(Pawn pawn) {
        return pawn.getColor().equals(WHITE);
    }

    public boolean isBlack(Pawn pawn) {
        return pawn.getColor().equals(BLACK);
    }
}
