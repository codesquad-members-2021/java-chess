package net.coco.pieces;

public class Piece {
    private final Color color;
    private final char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }



    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
