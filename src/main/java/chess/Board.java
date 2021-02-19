package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Pawn;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    private void initialize() {
        Pawn whitePawn = new Pawn();
        List<Pawn> whitePawns = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            whitePawns.add(whitePawn);
        }
        Pawn blackPawn = new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
        List<Pawn> blackPawns = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            blackPawns.add(blackPawn);
        }
    }

}
