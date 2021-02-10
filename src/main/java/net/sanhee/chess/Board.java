package net.sanhee.chess;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> pawns  = new ArrayList<Pawn>();

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }
}
