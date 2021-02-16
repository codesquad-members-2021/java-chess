package net.sky.pieces;

public class Pawn {

    private final Color color;
    private final char representation;

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = color.getRepresentation();
    }

    public Pawn(Color color) {
        this.color = color;
        this.representation = color.getRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

}
