package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawns = new ArrayList<>();
    private static final int PAWNSNUM = 8;

    public void add(Pawn pawn) {
        this.pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }

    public void initialize() {

    }

    public void print() {

    }
}
