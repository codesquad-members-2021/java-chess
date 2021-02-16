package net.honux.chess;

import net.honux.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

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

    public List<Pawn> getPawnListByColor(String color) {
        if (color.equals(Pawn.WHITE_COLOR)) {
            return whitePawns;
        } else if (color.equals(Pawn.BLACK_COLOR)) {
            return blackPawns;
        }
        throw new IllegalArgumentException("Cannot get the pawn list of this color, " + color);
    }

    public void initialize() {

    }

    public String getWhitePawnsResult() {
        return "";
    }

    public String getBlackPawnsResult() {
        return "";
    }
}
