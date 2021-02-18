package net.sky.pieces;

public enum PieceType {
    PAWN('p'), KNIGHT('n'), ROOK('r'), BISHOP('b'), QUEEN('q'), KING('k');

    private final char REPRESENTATION;

    PieceType(char representation) {
        this.REPRESENTATION = representation;
    }

    public char getRepresentation() {
        return REPRESENTATION;
    }
}
