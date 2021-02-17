package net.eno.pieces;

public class Piece {

    private final String color;
    private final char representation;

    public Piece() {
        this.color = Color.WHITE.toString();
        this.representation = Representation.WHITE.getPawn();
    }

    public Piece(Color color, Representation representation) {
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
