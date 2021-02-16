package net.isaac.pieces;

public class Pawn {
    private PieceColor color;

    public Pawn() {
        this.color = PieceColor.WHITE;
    }

    public Pawn(PieceColor color){
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }
}
