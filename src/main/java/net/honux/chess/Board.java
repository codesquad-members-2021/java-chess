package net.honux.chess;

import net.honux.chess.pieces.Pawn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> board = new ArrayList<>();

    private ArrayList<Pawn> whitePawns = new ArrayList<>();
    private ArrayList<Pawn> blackPawns = new ArrayList<>();

    public void add(Pawn white) {
        board.add(white);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int i) {
        return board.get(i);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }
}
