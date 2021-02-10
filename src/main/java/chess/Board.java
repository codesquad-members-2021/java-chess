package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void addPawn(Pawn pawn) {
        this.pawns.add(pawn);
    }

    public int pawnSize() {
        return this.pawns.size();
    }

    public Pawn findPawn(int index) {
        return this.pawns.get(index);
    }

}
