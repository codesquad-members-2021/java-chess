package net.nas.chess;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pieceList;

    public Board() {
        pieceList = new ArrayList<Pawn>();
    }

    public Pawn findPawn(int idx) {
        return pieceList.stream()
                .skip(idx)
                .findFirst()
                .orElse(null);
    }

    public void add(Pawn piece) {
        if(piece == null)
            throw new InvalidParameterException("Null value cannot be added in board");
        pieceList.add(piece);
    }

    public int size() {
        return pieceList.size();
    }
}
