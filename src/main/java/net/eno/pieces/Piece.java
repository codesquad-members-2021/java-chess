package net.eno.pieces;

public class Piece {

    private final String color;
    private final char representation;

    private Piece(Color color, Representation representation) {
        this.color = color.toString();
        this.representation = representation.get(color);
    }

    public static Piece createPiece(Color color, Representation representation) {
        return new Piece(color, representation);
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }

}
