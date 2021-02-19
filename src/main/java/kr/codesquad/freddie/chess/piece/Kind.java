package kr.codesquad.freddie.chess.piece;

public enum Kind {
    PAWN("p"),
    KNIGHT("n"),
    ROOK("r"),
    BISHOP("b"),
    QUEEN("q"),
    KING("k"),
    EMPTY(".");

    private final String representation;

    Kind(String representation) {
        this.representation = representation;
    }

    public String representation() {
        return representation;
    }
}
