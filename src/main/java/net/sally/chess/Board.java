package net.sally.chess;

import net.sally.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();

    public void addPawn(Pawn pawn) {
        pawns.add(pawn);
    }

    public int getPawnSize() {
        return pawns.size();
    }

    public Pawn findPawn(int i) {
        return pawns.get(i);
    }
}
