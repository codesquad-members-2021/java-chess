package net.sky.chess;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.IntStream;
import net.sky.pieces.Pawn;
import net.sky.pieces.Pawn.Color;
import net.sky.pieces.Pawn.Representation;

public class Board {

    private List<Pawn> whitePawns;

    private List<Pawn> blackPawns;

    public Board() {
        whitePawns = new ArrayList<>();
        blackPawns = new ArrayList<>();
    }

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
            addWhitePawn(new Pawn(Color.WHITE, Representation.p));
            addBlackPawn(new Pawn(Color.BLACK, Representation.P));
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder result = new StringBuilder();
        whitePawns.forEach((x) -> result.append(x.getRepresentation().getValue()));
        return result.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder result = new StringBuilder();
        blackPawns.forEach((x) -> result.append(x.getRepresentation().getValue()));
        return result.toString();
    }

    public void print() {
        String blankLine = "........";
        StringBuilder result = new StringBuilder();
        IntStream.range(0, 8).forEach((x) -> {
            if (x == 1) {
                result.append(getBlackPawnsResult());
            } else if (x == 6) {
                result.append(getWhitePawnsResult());
            } else {
                result.append(blankLine);
            }
            result.append("\n");
        });
        System.out.println(result);
    }
}
