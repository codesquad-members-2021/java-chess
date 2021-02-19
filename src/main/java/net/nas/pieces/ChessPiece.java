package net.nas.pieces;

public class ChessPiece {
    private final NameOfChessPiece name;
    private final ColorOfChessPiece color;

    private ChessPiece(NameOfChessPiece name, ColorOfChessPiece color) {
        this.name = name;
        this.color = color;
    }

    public static ChessPiece createChessPiece(NameOfChessPiece name, ColorOfChessPiece color) {
        return new ChessPiece(name, color);
    }

    public String getRepresentation() {
        return color.getRepresentationByColor(name.getRepresentation());
    }
}
