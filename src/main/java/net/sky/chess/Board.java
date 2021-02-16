package net.sky.chess;

import java.util.ArrayList;
import java.util.List;

import net.sky.pieces.Color;
import net.sky.pieces.Pawn;

public class Board {

    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public int getWhitePawnsSize() {
        return whitePawns.size();
    }

    public int getBlackPawnsSize() {
        return blackPawns.size();
    }

    public Pawn findWhitePawn(int idx) {
        return whitePawns.get(idx);
    }

    public Pawn findBlackPawn(int idx) {
        return blackPawns.get(idx);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
            addBlackPawn(new Pawn(Color.BLACK));
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder result = new StringBuilder();
        for (Pawn pawn : whitePawns) {
            result.append(pawn.getRepresentation());
        }
        return result.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder result = new StringBuilder();
        for (Pawn pawn : blackPawns) {
            result.append(pawn.getRepresentation());
        }
        return result.toString();
    }

    public void print() {
        String blankLine = "........";
        StringBuilder result = new StringBuilder();

        result.append(blankLine).append("\n");
        result.append(getBlackPawnsResult()).append("\n");
        result.append(blankLine).append("\n");
        result.append(blankLine).append("\n");
        result.append(blankLine).append("\n");
        result.append(blankLine).append("\n");
        result.append(getWhitePawnsResult()).append("\n");
        result.append(blankLine).append("\n");

        System.out.println(result);
    }
}
