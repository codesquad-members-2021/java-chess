package net.coco.pieces;

public enum PawnEnum {
    WHITE_COLOR("p")
    ,BLACK_COLOR("P");

    PawnEnum(String representation) {
        this.representation = representation;
    }

    public String representation;
}
