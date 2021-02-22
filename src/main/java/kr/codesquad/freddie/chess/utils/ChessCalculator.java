package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.File;
import kr.codesquad.freddie.chess.piece.Color;

import java.util.List;

public interface ChessCalculator {
     double calculate(List<File> files, Color color);
}
