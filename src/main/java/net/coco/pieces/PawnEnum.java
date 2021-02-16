package net.coco.pieces;

public enum PawnEnum {
    WHITE('p')
    , BLACK('P');

    PawnEnum(char representation) {
        this.representation = representation;
    }

    public final char representation;
}
