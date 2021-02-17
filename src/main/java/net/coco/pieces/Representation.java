package net.coco.pieces;

public enum Representation {
    WHITE_PAWN('p'),
    BLACK_PAWN('P');

    private char representation;

    Representation(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }
}
