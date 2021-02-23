package net.eno.pieces;

public enum PieceType {

    PAWN('p'),
    ROOK('r'),
    KNIGHT('n'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k'),
    NO_PIECE('.');

    private final char representation;

    PieceType(char representation) {
        this.representation = representation;
    }

    public char getRepresentation(Color color) {
        if (color.equals(Color.BLACK)) {
            return Character.toUpperCase(this.representation);
        } else {
            return this.representation;
        }
    }

}
