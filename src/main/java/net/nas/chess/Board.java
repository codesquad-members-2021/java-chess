package net.nas.chess;

import net.nas.pieces.Pawn;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pieceList;

    public Board() {
        pieceList = new ArrayList<Pawn>();
    }

    public Pawn findPawn(int idx) {
        if (idx < 0 || pieceList.size() <= idx)
            throw new InvalidParameterException("index exceeded the bounds of the pieceList");
        return pieceList.get(idx);
    }

    public void add(Pawn piece) {
        if (piece == null)
            throw new InvalidParameterException("Null value cannot be added in board");
        pieceList.add(piece);
    }

    public int size() {
        return pieceList.size();
    }
}
