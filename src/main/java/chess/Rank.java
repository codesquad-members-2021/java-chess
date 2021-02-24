package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>(8);
    private int rankNum;

    public Rank(int rankNum) {
        this.rankNum = rankNum;
    }

    public void setPieceList() {

    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public long count(Piece.Color color, Piece.Type type) {
        return pieceList.stream().filter(x -> x.getColor().equals(color))
                .filter(x -> x.getType().equals(type))
                .count();
    }
}
