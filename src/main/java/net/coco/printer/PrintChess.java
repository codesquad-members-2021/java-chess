package net.coco.printer;

import net.coco.chess.Board;
import net.coco.pieces.Piece;
import net.coco.utils.StringUtils;

public class PrintChess {
    private static final String BLANK = StringUtils.appendNewLine("********");

    public static void printBoard(Board board) {

        StringBuilder boardPrint = new StringBuilder();
        String blackPawns = board.getPawnsResult(Piece.BLACK);
        String whitePawns = board.getPawnsResult(Piece.WHITE);
        String blackOtherPieces = board.getOtherPiecesResult(Piece.BLACK);
        String whiteOtherPieces = board.getOtherPiecesResult(Piece.WHITE);

        boardPrint.append(StringUtils.appendNewLine(blackOtherPieces))
                .append(StringUtils.appendNewLine(blackPawns))
                .append(BLANK)
                .append(BLANK)
                .append(BLANK)
                .append(BLANK)
                .append(StringUtils.appendNewLine(whitePawns))
                .append(StringUtils.appendNewLine(whiteOtherPieces));

        System.out.println(boardPrint);
    }
}
