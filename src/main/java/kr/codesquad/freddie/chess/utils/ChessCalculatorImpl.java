package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.File;
import kr.codesquad.freddie.chess.piece.CalculablePiece;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChessCalculatorImpl implements ChessCalculator {
    @Override
    public double calculate(List<File> files, Color color) {
        double result = 0;
        for (Map.Entry<CalculablePiece, Double> entry : groupingByCalculablePiece(files, color).entrySet()) {
            double point = entry.getValue();
            Kind kind = entry.getKey().getKind();
            result += kind == Kind.PAWN && 1 < point ? point / 2 : point;
        }

        return result;
    }

    public Map<CalculablePiece, Double> groupingByCalculablePiece(List<File> files, Color color) {
        return files.stream()
                .flatMap(file -> file.getCalculablePieces())
                .filter(calculablePiece -> calculablePiece.getColor() == color)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingDouble(calculablePiece -> calculablePiece.getKind().point()))
                );
    }
}
