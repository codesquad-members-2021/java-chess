package net.nas.pieces;

public class Pawn {
    private final ColorOfChessPiece color;

    public Pawn(ColorOfChessPiece color) {
        this.color = color;
    }

    public Pawn() {
        this.color = ColorOfChessPiece.WHITE;
    }

    public ColorOfChessPiece getColor() {
        return color;
    }
}
