package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.piece.CalculablePiece;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;

import java.util.Map;

public class ChessCalculator {
    public double calculateScore(Calculable calculable, Color color) {
        Map<CalculablePiece, Double> calculablePieces = calculable.groupingByCalculablePiece(color);

        return calculablePieces.entrySet().stream()
                .mapToDouble(calculablePieceDoubleEntry -> {
                    double point = calculablePieceDoubleEntry.getValue();
                    Kind kind = calculablePieceDoubleEntry.getKey().getKind();
                    return kind == Kind.PAWN && Kind.PAWN.point() < point ? point / 2 : point;
                }).sum();
    }
}
