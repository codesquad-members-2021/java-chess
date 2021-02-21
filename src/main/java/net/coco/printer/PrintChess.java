package net.coco.printer;

import net.coco.chess.Board;
import net.coco.pieces.Piece;
import net.coco.utils.StringUtils;

public class PrintChess {

    public static String printBoard(Board board) {
        String blank = StringUtils.appendNewLine("********");

        StringBuilder boardPrint = new StringBuilder();
        String blackPawns = board.getBlackPawnsResult(Piece.BLACK);
        String whitePawns = board.getWhitePawnsResult(Piece.WHITE);
        String otherBlackPieces = board.getOtherBlackPiecesResult(Piece.BLACK);
        String otherWhitePieces = board.getOtherWhitePiecesResult(Piece.WHITE);

        boardPrint.append(StringUtils.appendNewLine(otherBlackPieces))
                .append(StringUtils.appendNewLine(blackPawns))
                .append(blank)
                .append(blank)
                .append(blank)
                .append(blank)
                .append(StringUtils.appendNewLine(whitePawns))
                .append(StringUtils.appendNewLine(otherWhitePieces));

        System.out.println(boardPrint);

        return boardPrint.toString();
    }
}
