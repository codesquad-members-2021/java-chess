package board;

import pieces.Pawn;

import java.util.ArrayList;

public class Board {

    private ArrayList<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void addPawn(Pawn pawn) {
        this.pawns.add(pawn);
    }

}
