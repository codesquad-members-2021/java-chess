package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> whitePawn = new ArrayList<>();
    List<Pawn> blackPawn = new ArrayList<>();

    char[][] board = new char[8][8];

    public void addWhitePawn(Pawn pawn) {
        whitePawn.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawn.add(pawn);
    }

    public int whitePawnSize() {
        return whitePawn.size();
    }

    public int blackPawnSize() {
        return blackPawn.size();
    }

    public Pawn getWhitePawn(int index) {
        return whitePawn.get(index);
    }

    public Pawn getBlackPawn(int index) {
        return blackPawn.get(index);
    }


}
