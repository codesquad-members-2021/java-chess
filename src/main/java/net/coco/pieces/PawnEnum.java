package net.coco.pieces;

public enum PawnEnum {
    WHITE('p'),
    BLACK('P');

    private char representation;

    PawnEnum(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }
}
