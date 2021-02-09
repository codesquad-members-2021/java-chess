package net.honux.chess.core;

import net.honux.chess.entity.pieces.Pawn;
import net.honux.chess.entity.pieces.Piece;

import java.util.ArrayList;

public class Board {
    private final static int CHESS_BOARD_SIZE = 8;
    private final Piece[][] board = new Piece[CHESS_BOARD_SIZE][CHESS_BOARD_SIZE];
    ArrayList<Pawn> pawnList = new ArrayList<>();

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int size() {
        return pawnList.size();
    }

    public Pawn findPawn(int index) {
        return pawnList.get(index);
    }

}
