package net.eno.pieces;

public class Piece {

    private final Color color;
    private final Representation representation;

    private Piece(Color color, Representation representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createPiece(Color color, Representation representation) {
        return new Piece(color, representation);
    }

    public String getColor() {
        return this.color.toString();
    }

    public char getRepresentation() {
        return this.representation.get(this.color);
    }

    public boolean isWhite() {
        return this.color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return this.color.equals(Color.BLACK);
    }

}
