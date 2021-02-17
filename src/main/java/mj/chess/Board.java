package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns = new ArrayList<>();
    private final StringBuffer rowOfBlackPawns = new StringBuffer();
    private final StringBuffer rowOfWhitePawns = new StringBuffer();
    private final String[] boardCells = {
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
        while (pawns.size() < 8) {
            pawns.add(new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION));
            rowOfBlackPawns.append(Pawn.BLACK_REPRESENTATION);
        }
        boardCells[1] = getBlackPawnsLocation();

        while (pawns.size() < 16) {
            pawns.add(new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION));
            rowOfWhitePawns.append(Pawn.WHITE_REPRESENTATION);
        }
        boardCells[6] = getWhitePawnsLocation();
    }

    public void print() {
        for (String rowOfBoard : boardCells) {
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
