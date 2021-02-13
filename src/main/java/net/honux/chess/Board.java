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
        if (idx < 0) {
            throw new NegativeArraySizeException("Negative numeric value " + idx + " cannot be a idx!");
        }
        if (size() <= idx) {
            throw new IndexOutOfBoundsException("Index number " + idx + " is out of range!");
        }
        return pawns.get(idx);
    }
}
