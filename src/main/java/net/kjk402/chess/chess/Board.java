package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pawnList = new ArrayList<>();

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int size() {
        return pawnList.size();
    }

    public Pawn findPwan(int idx) {
        return pawnList.get(idx);
    }

}
