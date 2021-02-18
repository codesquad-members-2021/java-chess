package kr.codesquad.freddie.chess.piece;

public enum Kind {
    PAWN("p"),
    KNIGHT("n"),
    ROOK("r"),
    BISHOP("b"),
    QUEEN("q"),
    KING("k");

    public final String REPRESENTATION;

    Kind(String representation) {
        this.REPRESENTATION = representation;
    }
}
