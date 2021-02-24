package net.woody.chess;

public enum Type {

    PAWN('p'),
    KNIGHT('n'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k'),
    NO_PIECE('.');

    private char representation;

    Type(char representation) {
        this.representation = representation;
    }

    public char value() {
        return representation;
    }

}
