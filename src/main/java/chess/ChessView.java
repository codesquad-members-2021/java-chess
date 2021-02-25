package chess;

import piece.Piece;

import static util.StringUtil.NEWLINE;


public class ChessView {
    public String getResultToPrint(Board board) {
        StringBuilder result = new StringBuilder();
        int count = board.BOARD_SIZE * board.BOARD_SIZE;
        for (Piece piece : board.getSquares().values()) {
            result.append(piece.getRepresentation()).append(" ");
            count--;
            if (count % board.BOARD_SIZE == 0) {
                result.append("  ").append(count / board.BOARD_SIZE + 1).append(NEWLINE);
            }
        }
        result.append(NEWLINE).append("a b c d e f g h ");
        return result.toString();
    }
}
