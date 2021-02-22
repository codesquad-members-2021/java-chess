package net.sky.pieces;

public enum PieceType {
    PAWN('p'),
    KNIGHT('n'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k'),
    NO_PIECE('.');


    private final char representation;

    PieceType(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }
}
