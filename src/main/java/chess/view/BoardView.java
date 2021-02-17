package chess.view;

import chess.board.Board;
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
}
