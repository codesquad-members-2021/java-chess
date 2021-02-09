package net.honux.chess;

import java.util.ArrayList;

public class Board {

    private ArrayList<Pawn> board = new ArrayList<>();

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
