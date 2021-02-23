package net.sky.chess;

import java.util.ArrayList;
import java.util.List;
import net.sky.pieces.Piece;

public class Rank {

    private List<Piece> rank = new ArrayList<>();

    public void add(Piece piece) {
        rank.add(piece);
    }

    public List<Piece> getRank() {
        return rank;
    }

    public int pieceCount(Piece piece) {
        int pieceCount = 0;

        for (Piece p : rank) {
            if (p.getPieceType() == piece.getPieceType() && p.getColor() == piece.getColor()) {
                pieceCount += 1;
            }
        }

        return pieceCount;
    }
}
