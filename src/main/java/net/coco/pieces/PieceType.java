package net.coco.pieces;

public enum PieceType {
    PAWN('p', 1.0),
    KNIGHT('n', 2.5),
    ROOK('r', 5.0),
    BISHOP('b', 3.0),
    QUEEN('q', 9.0),
    KING('k', 0.0),
    NO_PIECE('.', 0.0);

    private char representation;
    private double score;

    PieceType(char representation, double score) {
        this.representation = representation;
        this.score = score;
    }

    public char getRepresentation(Piece.Color color) {
        if (color == Piece.Color.WHITE) {
            return getWhiteRepresentation();
        }
        return getBlackRepresentation();
    }

    private char getWhiteRepresentation() {
        return representation;
    }

    private char getBlackRepresentation() {
        return Character.toUpperCase(representation);
    }

    public double getScore() {
        return score;
    }
}
