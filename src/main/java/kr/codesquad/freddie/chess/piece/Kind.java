package kr.codesquad.freddie.chess.piece;

import java.util.Locale;

public enum Kind {
    PAWN("p"),
    KNIGHT("k"),
    ROOK("r"),
    BISHOP("b"),
    QUEEN("q"),
    KING("k");

    public final String REPRESENTATION;

    Kind(String representation) {
        this.REPRESENTATION = representation;
    }
}
