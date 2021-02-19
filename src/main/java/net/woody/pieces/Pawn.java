package net.woody.pieces;

public class Pawn {
    public static final char PAWN_REPRESENTATION = 'p';
    public static final int BLACK_PAWN_RANK = 1;
    public static final int WHITE_PAWN_RANK = 6;

    private Color color;
    private char representation;

    public Pawn() {
        this(Color.WHITE.colorName());
    }

    public Pawn(String color) {
        this.color = Color.color(color);
        this.representation = this.color.representation(PAWN_REPRESENTATION);
    }

    public String getColorName() {
        return color.colorName();
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
