package net.eno.pieces;

public class Pawn {

    private final String color;
    private final char representation;

    public Pawn() {
        this.color = Piece.WHITE.getColor();
        this.representation = Piece.WHITE.getPawn();
    }

    public Pawn(Piece piece) {
        this.color = piece.getColor();
        this.representation = piece.getPawn();
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }

}
