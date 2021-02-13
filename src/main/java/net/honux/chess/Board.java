package net.honux.chess;

import net.honux.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns = new ArrayList<>();

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
