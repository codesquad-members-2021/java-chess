package util;

import chess.Rank;
import piece.Piece;

import java.util.List;
import java.util.ListIterator;

public class StringUtils {
    private static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String rankToString(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return appendNewLine(sb.toString());
    }

    public static String boardToString(List<Rank> ranks) {
        StringBuilder sb = new StringBuilder();
        ListIterator<Rank> rankIter = ranks.listIterator(ranks.size());
        while (rankIter.hasPrevious()) {
            sb.append(rankToString(rankIter.previous().getPieces()));
        }
        return sb.toString();
    }

    public static String appendNewLine(String str) {
        return str + NEWLINE;
    }
}
