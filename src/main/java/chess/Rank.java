package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>(8);
    private int rankNum;

    public Rank(int rankNum){
        this.rankNum = rankNum;
    }

    public void setPieceList(){

    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void add(Piece piece){
        pieceList.add(piece);
    }
}
