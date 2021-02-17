package net.coco.pieces;

public class Piece {
    private PawnEnum color;
    private char representation;

    public Piece() {
        this.color = PawnEnum.WHITE;
        this.representation = PawnEnum.WHITE.getRepresentation();
    }

    public Piece(PawnEnum pawnEnum) {
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
