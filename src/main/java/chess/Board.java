package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int PAWNSNUM = 8;
    private static final int COLUMN = 8;
    private List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        this.pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }

    public void initialize() {
        List board = new ArrayList(8);

        for (int i = 0; i < COLUMN; i++) {
            List boardColumn = new ArrayList(8);
            if (i == 1) {
                for (int j = 0; j < PAWNSNUM; j++) {
                    boardColumn.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK__REPRESENTATION));
                }
            }
            if (i == 6) {
                for (int j = 0; j < PAWNSNUM; j++) {
                    boardColumn.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
                }
            }
            board.add(boardColumn);
        }

    }

    public void print() {
    }
}
