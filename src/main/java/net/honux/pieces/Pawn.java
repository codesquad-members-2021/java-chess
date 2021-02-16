package net.honux.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';

    private String color;
    private char representation;

    public Pawn() {
        this(WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public Pawn(String color, char representation) {
        if (!color.equals(WHITE_COLOR) && !color.equals(BLACK_COLOR)) {
            throw new IllegalArgumentException("Pawn color should be 'white' or 'black'!");
        }
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
