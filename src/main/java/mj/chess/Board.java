package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private static final int MAX_SIZE = 8;
    private static final int SECOND_ROW = 1;
    private static final int SEVENTH_ROW = 6;
    private final List<Pawn> pawns = new ArrayList<>();
    private final StringBuilder rowOfBlackPawns = new StringBuilder();
    private final StringBuilder rowOfWhitePawns = new StringBuilder();
    private final String[] cellsOfBoard = {
            "********",
            "********",
            "********",
            "********",
            "********",
            "********",
            "********",
            "********"
    };

    public Board() {
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    public void initialize() {
        initPawns(Color.WHITE, SECOND_ROW, rowOfWhitePawns);
        initPawns(Color.BLACK, SEVENTH_ROW, rowOfBlackPawns);
    }

    private void initPawns(Color color, final int NTH_ROW, StringBuilder rowOfPawns) {
        for (int i = 0; i < MAX_SIZE; i++) {
            Pawn pawn = new Pawn(color);
            pawns.add(pawn);
            rowOfPawns.append(pawn.getRepresentation());
        }
        cellsOfBoard[NTH_ROW] = (color == Color.BLACK) ? getRowOfBlackPawns() : getRowOfWhitePawns();
    }

    public void print() {
        for (String rowOfBoard : cellsOfBoard) {
            System.out.println(rowOfBoard);
        }
    }

    public String getRowOfBlackPawns() {
        return rowOfBlackPawns.toString();
    }

    public String getRowOfWhitePawns() {
        return rowOfWhitePawns.toString();
    }
}
