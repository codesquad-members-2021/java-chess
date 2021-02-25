package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static chess.pieces.Piece.*;

public class Rank {
    private List<Piece> pieces = new ArrayList<>();

    public List<Piece> pieces() {
        return Collections.unmodifiableList(pieces);
    }

    public int size() {
        return pieces.size();
    }

    public void add(final Piece piece) {
        pieces.add(piece);
    }

    public void addAll(final List<Piece> piece) {
        pieces.addAll(piece);
    }

    public long pieceCountOf(Color color, Type type) {
        long pieceCount = pieces.stream()
                .filter(piece -> piece.getColor() == color && piece.getType() == type)
                .count();
        return pieceCount;
    }

    public Piece getPieceOf(int file) {
        return pieces.get(file);
    }

    public void set(int index, Piece piece) {
        pieces.set(index, piece);
    }

    public List<Piece> getPiecesOf(Color color) {
        List<Piece> piecesOfColor = pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .collect(Collectors.toList());
        return piecesOfColor;
    }

    public double getScoreOf(Color color) {
        double score = pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .mapToDouble(piece -> piece.getType().getDefaultPoint())
                .sum();
        return score;
    }

    public List<Integer> getFilesOfPawns(Color color) {
        List<Integer> filesOfPawns = pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .map(piece -> pieces.indexOf(piece))
                .collect(Collectors.toList());
        return filesOfPawns;
    }
}
