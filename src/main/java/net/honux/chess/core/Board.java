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
        Pawn pawn = null;
        try {
            pawn = pawnList.get(index);
        }catch (IndexOutOfBoundsException e){
            System.out.println("해당 위치에 Pawn 이 존재하지 않습니다.");
        }
        return pawn;
    }

}
