package chess.view;

import chess.domain.board.Board;
import chess.domain.board.position.Position;
import chess.utils.StringUtils;

import static chess.domain.board.BoardConst.*;

public class BoardView {
    private final Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    private void appendRow(StringBuilder sb, int rowId) {
        for (char columnId = COLUMN_START; columnId <= COLUMN_END; columnId++) {
            Position position = Position.of(columnId, rowId);
            sb.append(board.getPiece(position));
            sb.append(" ");
        }
        sb.append(StringUtils.NEWLINE);
    }

    public String getBoardRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("  a b c d e f g h ");
        sb.append(StringUtils.NEWLINE);
        for (int rowId = ROW_END; rowId >= ROW_START; rowId--) {
            sb.append(rowId);
            sb.append(" ");
            appendRow(sb, rowId);
        }
        return sb.toString();
    }
}
