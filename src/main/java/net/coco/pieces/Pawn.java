package net.coco.pieces;

public class Pawn {
    private PawnEnum color;
    private char representation;

    public Pawn() {
        this.color = PawnEnum.WHITE_COLOR;
        this.representation = PawnEnum.WHITE_COLOR.representation;
    }

    public Pawn(PawnEnum pawnEnum) {
        this.color = pawnEnum;
        this.representation = pawnEnum.representation;
    }

    public PawnEnum getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
