package net.woody.chess;

public enum Representation {

    PAWN('p'), KNGINT('n'), ROOK('r'), BISHOP('b'), QUEEN('q'), KING('k');

    private char representation;

    Representation(char representation) {
        this.representation = representation;
    }

    public char white() {
        return representation;
    }

    public char black() {
        return Character.toUpperCase(representation);
    }
}
