package net.sky.chess;

import java.util.ArrayList;
import java.util.List;

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

    public int whitePawnsSize() {
        return whitePawns.size();
    }

    public int blackPawnsSize() {
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
        blackPawns.stream().forEach((x) -> result.append(x.getRepresentation().getValue()));
        return result.toString();
    }
}
