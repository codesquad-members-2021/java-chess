package chess.pieces;

public enum PieceName {
    PAWN('p'),
    KNIGHT('n'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k');

    private final char tempRepresentation;

    PieceName(char representation) {
        this.tempRepresentation = representation;
    }

    public char getTempRepresentation() {
        return tempRepresentation;
    }
}
