package net.coco.Printer;

import net.coco.chess.Board;
import net.coco.pieces.PawnEnum;
import net.coco.utils.StringUtils;

public class PrintChess {
    private static final String BLANK = StringUtils.appendNewLine("********");

    public static void printBoard(Board board) {

        StringBuilder boardPrint = new StringBuilder();
        String blackPawns = board.getPawnsResult(PawnEnum.BLACK);
        String whitePawns = board.getPawnsResult(PawnEnum.WHITE);
        boardPrint.append(BLANK)
                .append(StringUtils.appendNewLine(blackPawns))
                .append(BLANK)
                .append(BLANK)
                .append(BLANK)
                .append(BLANK)
                .append(StringUtils.appendNewLine(whitePawns))
                .append(BLANK);

        System.out.println(boardPrint);
    }
}
