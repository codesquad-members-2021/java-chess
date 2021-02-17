package chess.view;

import chess.board.Board;
import chess.pieces.Piece;
import chess.utils.StringUtils;

import java.util.Iterator;
import java.util.List;

public class BoardView {
    private final Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    private void appendRow(StringBuilder sb, Iterator itr) {
        for (int i = 0; itr.hasNext() && i < 8; i++) {
            sb.append(itr.next());
            sb.append(" ");
        }
        sb.append(StringUtils.NEWLINE);
    }

    private String getRepresentation(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator itr = list.iterator();
        for (int i = 0; i < 8; i++) {
            appendRow(sb, itr);
        }
        return sb.toString();
    }

    public String getPositionRepresentation() {
        return getRepresentation(board.getPositions());
    }

    public String getPieceRepresentation() {
        return getRepresentation(board.getPieces());
    }

    public String getBoardRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("  a b c d e f g h ");
        sb.append(StringUtils.NEWLINE);
        Iterator<Piece> itr = board.getPieces().iterator();
        for (int i = 8; i >= 1; i--) {
            sb.append(i);
            sb.append(" ");
            appendRow(sb, itr);
        }
        return sb.toString();
    }
}
