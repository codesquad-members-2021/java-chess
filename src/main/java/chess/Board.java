package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> pawns = new ArrayList<>();

    void addPawn(Pawn pawn) {
        pawns.add(pawn);
    }

    int getPawnSize() {
        return pawns.size();
    }

    Pawn findPawn(int i) {
        return pawns.get(i);
    }
}
