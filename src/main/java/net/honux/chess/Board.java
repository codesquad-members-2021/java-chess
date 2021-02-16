package net.honux.chess;

import net.honux.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();

    public void add(Pawn pawn) {
        getPawnListByColor(pawn.getColor()).add(pawn);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findPawn(int idx, String color) {
        if (idx < 0 || size() <= idx) {
            throw new ArrayIndexOutOfBoundsException("Index number " + idx + " is out of range!");
        }
        return getPawnListByColor(color).get(idx);
    }

    private List<Pawn> getPawnListByColor(String color) {
        if (color.equals(Pawn.WHITE_COLOR)) {
            return whitePawns;
        } else if (color.equals(Pawn.BLACK_COLOR)) {
            return blackPawns;
        }
        throw new IllegalArgumentException("Cannot get the pawn list of this color, " + color);
    }

    public void initialize() {
        IntStream.range(0, BOARD_LENGTH).forEach(i -> {
            whitePawns.add(i, new Pawn());
            blackPawns.add(i, new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        });
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : whitePawns) {
            char represent = (pawn == null) ? '.' : Pawn.WHITE_REPRESENTATION;
            sb.append(represent);
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : blackPawns) {
            char represent = (pawn == null) ? '.' : Pawn.BLACK_REPRESENTATION;
            sb.append(represent);
        }
        return sb.toString();
    }

}
