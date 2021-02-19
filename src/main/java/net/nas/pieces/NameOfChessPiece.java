package net.nas.pieces;

public enum NameOfChessPiece {
    PAWN("P"), ROOK("R"), KNIGHT("N"), BISHOP("B"), QUEEN("P"), KING("K");
    private final String representation;

    NameOfChessPiece(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
