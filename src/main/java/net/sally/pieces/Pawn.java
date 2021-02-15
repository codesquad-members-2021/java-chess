package net.sally.pieces;

public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';

    private final String color;

    public Pawn() {
        this.color = WHITE;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
