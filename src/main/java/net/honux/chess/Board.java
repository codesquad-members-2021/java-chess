package net.honux.chess;

import net.honux.pieces.Pawn;

import java.util.ArrayList;

public class Board {

    ArrayList<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        this.pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        if (idx < 0 || size() < idx) {
            throw new IndexOutOfBoundsException("Index number " + idx + " is out of range! There is/are " + size() + " pieces on the board.");
        }
        return pawns.get(idx);
    }
}
