package net.woody.chess;

import net.woody.pieces.Piece;

import java.util.List;

import static net.woody.factories.PieceFactory.*;

public class Rank {
    private final List<Piece> pieces;

    private Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void add(int file, Piece piece) {
        pieces.set(file, piece);
    }

    public Piece getPiece(int file) {
        return pieces.get(file);
    }

    public int getNumOfPiece(Piece target) {
        int targetCounter = 0;
        for (Piece piece : pieces) {
            targetCounter += target.equals(piece) ? 1 : 0;
        }
        return targetCounter;
    }

    public int size() {
        int pieceSize = 0;
        for (Piece piece : pieces) {
            pieceSize += piece.equals(getBlankInstance()) ? 0 : 1;
        }
        return pieceSize;
    }

    public static Rank createRank(List<Piece> pieces) {
        return new Rank(pieces);
    }

    @Override
    public String toString() {
        StringBuilder rank = new StringBuilder();

        // TODO : for-loop을 풀어적거나
        for (Piece piece : pieces) {
            rank.append(piece.getRepresentation());
        }
        return rank.toString();
    }
}
