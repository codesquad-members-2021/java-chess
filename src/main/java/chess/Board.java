package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawnList = new ArrayList<>();

    public Pawn findPawn(int index) {
        return pawnList.get(index);
    }

    public void add(Pawn pieces) {
        pawnList.add(pieces);
    }

    public int size() {
        return pawnList.size();
    }
}
