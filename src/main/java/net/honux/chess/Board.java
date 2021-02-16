package net.honux.chess;

import net.honux.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private ArrayList<Pawn> whitePawns = new ArrayList<>();
    private ArrayList<Pawn> blackPawns = new ArrayList<>();

    public void add(Pawn pawn) {
        distinguishPawnsColor(pawn).add(pawn);
    }

    public int size(Pawn pawn) {
        return distinguishPawnsColor(pawn).size();
    }

    public Pawn findPawn(Pawn pawn, int index) {
        return distinguishPawnsColor(pawn).get(index);
    }

    private ArrayList<Pawn> distinguishPawnsColor(Pawn pawn) {
        if (pawn.getColor() == Pawn.WHITE_COLOR)
            return whitePawns;
        else
            return blackPawns;
    }

    void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
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

