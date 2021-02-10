package net.nas.chess;

public abstract class ChessPiece {
    private ColorOfChessPiece color;

    public ChessPiece(ColorOfChessPiece color) {
        this.color = color;
    }

    public ColorOfChessPiece getColor() {
        return color;
    }
}
