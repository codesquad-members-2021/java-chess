package net.honux.chess.attribute;

public enum PawnName {
    WHITE_REPRESENTATION('p'), BLACK_REPRESENTATION('P');

    private final char representation;

    PawnName(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }
}
