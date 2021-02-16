package chess;

import java.util.ArrayList;

import pieces.Pawn;

public class Board {
    private ArrayList<Pawn> pawns = new ArrayList<>();

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
