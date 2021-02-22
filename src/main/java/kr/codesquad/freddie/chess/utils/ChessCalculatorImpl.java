package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.File;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChessCalculatorImpl implements ChessCalculator {
    @Override
    public  double calculate(List<File> files, Color color) {
        double result = getRotatedFilesBy(files, color).stream()
                .mapToDouble(File::calculate)
                .sum();

        return result;
    }

    public  List<File> getRotatedFilesBy(List<File> files, Color color) {
        List<File> rotatedFiles = new ArrayList<>();

        for (int i = 0; i < File.SIZE; i++) {
            rotatedFiles.add(new File());
        }

        List<Map<Character, Piece>> temp = files.stream()
                .map(File::toMap)
                .collect(Collectors.toList());

        for (Map<Character, Piece> map : temp) {
            for (Map.Entry<Character, Piece> entry : map.entrySet()) {
                if (entry.getValue().getColor() == color) {
                    rotatedFiles.get(entry.getKey() - 'a').add(entry.getValue());
                }
            }
        }

        return rotatedFiles;
    }
}
