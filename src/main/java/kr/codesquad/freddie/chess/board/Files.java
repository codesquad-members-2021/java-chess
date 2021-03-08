package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.CalculablePiece;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Files {
    private List<File> files = new ArrayList<>();

    public void add(File file) {
        files.add(file);
    }

    public void add(Piece piece) {
        files.stream()

                .filter(File::isAddable)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("더 이상 추가할 수 없습니다. 현재 크기 : " + pieceCount()))
                .add(piece);
    }

    public Piece findPiece(Position position) {
        return files.get(position.getRankIndexForList())
                .get(position.getFileIndexForList());
    }

    public void set(Position position, Piece piece) {
        files.get(position.getRankIndexForList())
                .set(position.getFileIndexForList(), piece);
    }

    public void fillWithRoyalAt(Color color) {
        RankIndex rankIndex = new RankIndex(color.royalInitializationRank());
        files.get(rankIndex.getRankIndexForList()).fillWithRoyal(color);
    }

    public void fillWithPawnAt(Color color) {
        RankIndex rankIndex = new RankIndex(color.pawnInitializationRank());
        files.get(rankIndex.getRankIndexForList()).fillWithPawn(color);
    }

    public void fillWithBlankAt(int index) {
        files.get(index).fillWithBlank();
    }

    public int pieceCount() {
        return files.stream()
                .mapToInt(File::size)
                .sum();
    }

    public Map<CalculablePiece, Double> groupingByCalculablePiece(Color color) {
        return files.stream()
                .flatMap(file -> file.getCalculablePieces().stream())
                .filter(calculablePiece -> calculablePiece.getColor() == color)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingDouble(CalculablePiece::getPoint)
                ));
    }

    public List<File> getFiles() {
        return Collections.unmodifiableList(files);
    }

    @Override
    public String toString() {
        return "Files{" +
                "files=" + files +
                '}';
    }
}
