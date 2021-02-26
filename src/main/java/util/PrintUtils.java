package util;

import chess.Board;
import piece.Color;
import piece.Piece;

import java.util.Collections;
import java.util.List;

public class PrintUtils {

    private PrintUtils() {
    }

    public static void showScore(Board board) {
        double whiteScore = board.calculatePoint(Color.WHITE);
        double blackScore = board.calculatePoint(Color.BLACK);
        System.out.println("[Total score]");
        System.out.println("✓ White score : " + whiteScore);
        System.out.println("✓ Black score : " + blackScore);
    }

    public static void showScoreByPiece(Board board) {
        List<Piece> whitePieces = board.findPiecesByColor(Color.WHITE);
        List<Piece> blackPieces = board.findPiecesByColor(Color.BLACK);
        whitePieces.sort(Collections.reverseOrder());
        blackPieces.sort(Collections.reverseOrder());
        System.out.println("\n[White Player's result]");
        for (Piece piece : whitePieces) {
            System.out.println(piece.getType() + " : " + piece.getType().getDefaultPoint());
        }
        System.out.println("\n[Black Player's result]");
        for (Piece piece : blackPieces) {
            System.out.println(piece.getType() + " : " + piece.getType().getDefaultPoint());
        }
    }
}
