package net.honux.chess.util;

import net.honux.chess.entity.pieces.Piece;

import java.util.*;
import java.util.function.Consumer;

public class PieceList{

    private List<Piece> pieceList = new ArrayList<>();

    public PieceList add(Piece piece){
        pieceList.add(piece);
        return this;
    }

    public int size(){
        return pieceList.size();
    }

    public Piece get(int index) {
        return pieceList.get(index);
    }

    public List<Piece> getPieceList() {
        return Collections.unmodifiableList(pieceList);
    }

    public String getStringPiecesList(int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        for(int i = startIndex; i <= endIndex; i++){
            sb.append(pieceList.get(i).getRepresentation());
        }
        return sb.toString();
    }
}
