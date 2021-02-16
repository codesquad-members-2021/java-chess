package chess.pieces;

public enum Color {
    WHITE('p'), BLACK('P');

    private final char representation;

    Color(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return this.representation;
    }
}
