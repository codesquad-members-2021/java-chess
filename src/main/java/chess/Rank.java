package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public long pieceCountOf(Piece.Color color, Piece.Type type) {
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

    public double calculatePoint(Piece.Color color) {
        double point = pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .mapToDouble(piece -> piece.getType().getDefaultPoint())
                .sum();
        return point;
    }

    public List<Integer> getFilesOfPawns(Piece.Color color) {
        List<Integer> filesOfPawns = new ArrayList<>();
        for (int i = 0; i < pieces.size(); i++) {
            Piece piece = pieces.get(i);
            if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
                filesOfPawns.add(i);
            }
        }
        return filesOfPawns;
    }
}
