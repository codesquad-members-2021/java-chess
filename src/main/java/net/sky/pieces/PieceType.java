package net.sky.pieces;

public enum PieceType {
    PAWN('p', 'P'), KNIGHT('n', 'N'), ROOK('r', 'R'), BISHOP('b', 'B'), QUEEN('q', 'Q'), KING('k',
        'K');

    private final char WHITE_REPRESENTATION;
    private final char BLACK_REPRESENTATION;

    PieceType(char white, char black) {
        this.WHITE_REPRESENTATION = white;
        this.BLACK_REPRESENTATION = black;
    }

    public char getRepresentation(Color color) {
        if (color.equals(Color.WHITE)) {
            return WHITE_REPRESENTATION;
        }
        return BLACK_REPRESENTATION;
    }
}
