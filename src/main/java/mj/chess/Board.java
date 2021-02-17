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
        initPawns(Color.WHITE, Pawn.WHITE_REPRESENTATION, SECOND_ROW, rowOfWhitePawns);
        initPawns(Color.BLACK, Pawn.BLACK_REPRESENTATION, SEVENTH_ROW, rowOfBlackPawns);
    }

    private void initPawns(Color color, char representation, final int NTH_ROW, StringBuilder rowOfPawns) {
        for (int i = 0; i < MAX_SIZE; i++) {
            pawns.add(new Pawn(color));
            rowOfPawns.append(representation);
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
