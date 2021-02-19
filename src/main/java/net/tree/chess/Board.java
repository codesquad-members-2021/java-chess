package net.tree.chess;

import net.tree.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Pawn> pawnList = new ArrayList<>();

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int checkPawnSize() {
        return pawnList.size();
    }

    public Pawn findPawn(int i) {

        Pawn pawn = pawnList.get(i);

        return pawn;
    }
}
