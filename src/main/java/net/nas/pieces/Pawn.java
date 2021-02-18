package net.nas.pieces;

public class Pawn {
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";

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

    public String getRepresentation() {
        if (color == ColorOfChessPiece.WHITE)
            return WHITE_REPRESENTATION;
        else return BLACK_REPRESENTATION;
    }
}
