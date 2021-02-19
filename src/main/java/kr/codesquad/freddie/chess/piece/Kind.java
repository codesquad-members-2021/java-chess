package kr.codesquad.freddie.chess.piece;

public enum Kind {
    PAWN("p", 1.0),
    KNIGHT("n", 2.5),
    ROOK("r", 5.0),
    BISHOP("b", 3.0),
    QUEEN("q", 9.0),
    KING("k", 0.0),
    EMPTY(".", 0.0);

    private final String representation;
    private final double point;

    Kind(String representation, double point) {
        this.representation = representation;
        this.point = point;
    }

    public String representation() {
        return representation;
    }

    public double point() {
        return point;
    }
}
