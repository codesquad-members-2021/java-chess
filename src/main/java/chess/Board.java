package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();

    void add(Pawn pawn) {
        pawns.add(pawn);
    }

    int size() {
        return pawns.size();
    }

    Pawn findPawn(int index) {
        return pawns.get(index);
    }
}
