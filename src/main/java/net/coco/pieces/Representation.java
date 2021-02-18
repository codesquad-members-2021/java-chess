package net.coco.pieces;

public enum Representation {
    WHITE_PAWN('p'),
    BLACK_PAWN('P'),
    WHITE_KNIGHT('n'),
    BLACK_KNIGHT('N'),
    WHITE_ROOK('r'),
    BLACK_ROOK('R'),
    WHITE_BISHOP('b'),
    BLACK_BISHOP('B'),
    WHITE_QUEEN('q'),
    BLACK_QUEEN('Q'),
    WHITE_KING('k'),
    BLACK_KING('K');

    private char representation;

    Representation(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }
}
