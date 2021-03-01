package chess;

import piece.Piece;

import static chess.Board.BOARD_SIZE;
import static util.StringUtil.NEWLINE;

public class ChessView {
    public String view(Board board) {
        StringBuilder result = new StringBuilder();
        int count = BOARD_SIZE * BOARD_SIZE;
        for (Piece piece : board.getSquares().values()) {
            result.append(piece.getRepresentation()).append(" ");
            count--;
            if (count % BOARD_SIZE == 0) {
                result.append("  ").append(count / BOARD_SIZE + 1).append(NEWLINE);
            }
        }
        result.append(NEWLINE).append("a b c d e f g h ");
        return result.toString();
    }
}

