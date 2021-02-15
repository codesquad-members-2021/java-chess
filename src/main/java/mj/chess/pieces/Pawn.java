package mj.chess.pieces;

public class Pawn {
    private final ColorOfPiece color;

    public Pawn() {
        this.color = ColorOfPiece.WHITE;
    }

    public Pawn(ColorOfPiece color) {
        this.color = color;
    }

    public ColorOfPiece getColor() {
        return color;
    }

}
