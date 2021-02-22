package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.File;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ChessCalculator {
     double calculate(List<File> files, Color color);
}
