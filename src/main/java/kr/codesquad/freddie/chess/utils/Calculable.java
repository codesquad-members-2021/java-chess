package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.piece.CalculablePiece;
import kr.codesquad.freddie.chess.piece.Color;

import java.util.Map;

public interface Calculable {
    Map<CalculablePiece, Double> groupingByCalculablePiece(Color color);
}
