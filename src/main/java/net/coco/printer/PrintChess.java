package net.coco.printer;

import net.coco.chess.Board;
import net.coco.pieces.Piece;
import net.coco.utils.StringUtils;

public class PrintChess {

    public static String printBoard(Board board) {
        StringBuilder boardPrint = new StringBuilder();
        for (int i = 0; i < Board.BOARD_CELLS; i++) {
            String getRankToString = StringUtils.appendNewLine(board.getRankResult(i));
            boardPrint.append(getRankToString);
        }

        System.out.println(boardPrint);

        return boardPrint.toString();
    }
}
