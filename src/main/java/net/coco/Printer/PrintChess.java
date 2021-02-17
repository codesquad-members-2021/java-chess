package net.coco.Printer;

import net.coco.chess.Board;
import net.coco.pieces.PawnEnum;

public class PrintChess {
    private static final String BLANK = "********\n";

    public static void printBoard(Board board) {

        StringBuilder boardPrint = new StringBuilder();
        String blackPawns = board.getPawnsResult(PawnEnum.BLACK);
        String whitePawns = board.getPawnsResult(PawnEnum.WHITE);
        boardPrint.append(BLANK)
                .append(blackPawns + "\n")
                .append(BLANK)
                .append(BLANK)
                .append(BLANK)
                .append(BLANK)
                .append(whitePawns + "\n")
                .append(BLANK);

        System.out.println(boardPrint);
    }
}
