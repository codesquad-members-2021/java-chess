package chess.board;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns = new ArrayList<>();

    public int size() {
        return pawns.size();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }
}
