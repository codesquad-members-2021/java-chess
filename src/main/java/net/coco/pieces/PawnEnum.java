package net.coco.pieces;

public enum PawnEnum {
    WHITE_COLOR('p')
    ,BLACK_COLOR('P');

    PawnEnum(char representation) {
        this.representation = representation;
    }

    public final char representation;
}
