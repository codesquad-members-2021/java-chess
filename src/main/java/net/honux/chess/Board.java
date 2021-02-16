package net.honux.chess;

import net.honux.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int BOARD_LENGTH = 8;

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

    void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    private String listPawnsToSingleLine(ArrayList<Pawn> whichGroupOfPawns) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < BOARD_LENGTH; i++) {
            sb.append(whichGroupOfPawns.get(i).getRepresentation());
        }

        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return listPawnsToSingleLine(whitePawns);
    }

    public String getBlackPawnsResult() {
        return listPawnsToSingleLine(blackPawns);
    }

    public String getBlankLine() {
        return "........";
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getBlackPawnsResult());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getWhitePawnsResult());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        System.out.println(sb.toString());
    }
}

