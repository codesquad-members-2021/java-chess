package net.coco.pieces;

public class Pawn {
    private PawnEnum color;
    private char representation;

    public Pawn() {
        this.color = PawnEnum.WHITE;
        this.representation = PawnEnum.WHITE.getRepresentation();
    }

    public Pawn(PawnEnum pawnEnum) {
        this.color = pawnEnum;
        this.representation = pawnEnum.getRepresentation();
    }

    public PawnEnum getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
