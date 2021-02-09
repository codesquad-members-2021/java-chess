package chess;

import java.util.ArrayList;

public class Board {

    ArrayList<Pawn> pawns = new ArrayList<>();

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
