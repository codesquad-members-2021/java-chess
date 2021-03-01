package net.coco.printer;

import net.coco.chess.Board;
import net.coco.pieces.Piece;
import net.coco.utils.StringUtils;

public class PrintChess {

    public static String printBoard(Board board) {
        StringBuilder boardPrint = new StringBuilder();
        for (int i = Board.BOARD_CELLS - 1; i >= 0; i--) {
            String getRankToString = StringUtils.appendNewLine(board.getRankResult(i));
            boardPrint.append(getRankToString);
        }

        System.out.println(boardPrint);

        return boardPrint.toString();
    }
}
