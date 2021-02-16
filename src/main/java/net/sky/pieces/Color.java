package net.sky.pieces;

public enum Color {
    WHITE('p'), BLACK('P');
    private final char representation;

    Color(char representation) {
        this.representation = representation;
    }

    char getRepresentation() {
        return this.representation;
    }
}
