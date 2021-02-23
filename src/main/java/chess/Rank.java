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
}
