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
    private final StringBuffer rowOfBlackPawns = new StringBuffer();
    private final StringBuffer rowOfWhitePawns = new StringBuffer();
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
        while (pawns.size() < MAX_SIZE) {
            for (Color color : Color.values()) pawns.add(new Pawn(color));
            rowOfWhitePawns.append(Pawn.WHITE_REPRESENTATION);
            rowOfBlackPawns.append(Pawn.BLACK_REPRESENTATION);
        }
        cellsOfBoard[SECOND_ROW] = getBlackPawnsLocation();
        cellsOfBoard[SEVENTH_ROW] = getWhitePawnsLocation();
    }

    public void print() {
        for (String rowOfBoard : cellsOfBoard) {
            System.out.println(rowOfBoard);
        }
    }

    public String getBlackPawnsLocation() {
        return rowOfBlackPawns.toString();
    }

    public String getWhitePawnsLocation() {
        return rowOfWhitePawns.toString();
    }
}
