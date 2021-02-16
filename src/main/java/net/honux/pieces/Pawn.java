package net.honux.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = '0';
    public static final char BLACK_REPRESENTATION = '0';

    private String color;

    public Pawn() {
        this(WHITE_COLOR);
    }

    public Pawn(String color) {
        if (!color.equals(WHITE_COLOR) && !color.equals(BLACK_COLOR)) {
            throw new IllegalArgumentException("Pawn color should be 'white' or 'black'!");
        }
        this.color = color;
    }

    public Pawn(String color, char representation) {
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return '1';
    }
}
