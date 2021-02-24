package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>(8);
    private int rankNum;

    public Rank(int rankNum) {
        this.rankNum = rankNum;
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public void setPiece(int index, Piece piece) {
        pieceList.add(index,piece);
    }

    public void remove(int index) {
        pieceList.remove(index);
    }

    public long count(Piece.Color color, Piece.Type type) {
        return pieceList.stream().filter(x -> x.getColor() == color)
                .filter(x -> x.getType() == type)
                .count();
    }
}
