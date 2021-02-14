package mj.chess;

import mj.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawns = new ArrayList<>();

    public Board(){

    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }
}
