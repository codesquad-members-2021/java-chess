package net.coco.pieces;

public enum Representation {
    PAWN('p'),
    KNIGHT('n'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k');

    private char representation;

    Representation(char representation) {
        this.representation = representation;
    }

    public char getWhiteRepresentation() {
        return representation;
    }

    public char getBlackRepresentation() {
        return Character.toUpperCase(representation);
    }

}
