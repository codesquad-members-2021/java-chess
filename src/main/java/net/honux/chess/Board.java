package net.honux.chess;

import net.honux.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> board = new ArrayList<>();

    public void add(Pawn white) {
        board.add(white);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int i) {
        return board.get(i);
    }
}
