package net.eno.pieces;

public class Pawn {

    private final String color;
    private final char representation;

    public Pawn() {
        this.color = Color.WHITE.toString();
        this.representation = Representation.WHITE.getPawn();
    }

    public Pawn(Color color, Representation representation) {
        this.color = color.toString();
        this.representation = representation.getPawn();
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }

}
