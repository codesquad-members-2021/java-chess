package net.coco.pieces;

public class Piece {
    private Color color;
    private char representation;

    public Piece() {
        this.color = Color.WHITE;
        this.representation = Color.WHITE.getRepresentation();
    }

    public Piece(Color color) {
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
