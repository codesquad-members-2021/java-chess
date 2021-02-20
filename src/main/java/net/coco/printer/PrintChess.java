package net.coco.printer;

import net.coco.chess.Board;
import net.coco.pieces.Piece;
import net.coco.utils.StringUtils;

public class PrintChess {

    public static String printBoard(Board board) {
        String blank = StringUtils.appendNewLine("********");

        StringBuilder boardPrint = new StringBuilder();
        String blackPawns = board.getPawnsResult(Piece.BLACK);
        String whitePawns = board.getPawnsResult(Piece.WHITE);
        String blackOtherPieces = board.getOtherPiecesResult(Piece.BLACK);
        String whiteOtherPieces = board.getOtherPiecesResult(Piece.WHITE);

        boardPrint.append(StringUtils.appendNewLine(blackOtherPieces))
                .append(StringUtils.appendNewLine(blackPawns))
                .append(blank)
                .append(blank)
                .append(blank)
                .append(blank)
                .append(StringUtils.appendNewLine(whitePawns))
                .append(StringUtils.appendNewLine(whiteOtherPieces));

        System.out.println(boardPrint);

        return boardPrint.toString();
    }
}
