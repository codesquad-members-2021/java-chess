package net.sky.chess;

import java.util.ArrayList;
import java.util.List;

import net.sky.pieces.Pawn;
import net.sky.pieces.Pawn.Color;
import net.sky.pieces.Pawn.Representation;

public class Board {

    private List<Pawn> pawns;

    private List<Pawn> whitePawns;

    private List<Pawn> blackPawns;

    public Board() {
        pawns = new ArrayList<>();
        whitePawns = new ArrayList<>();
        blackPawns = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(Color.WHITE, Representation.p));
            blackPawns.add(new Pawn(Color.BLACK, Representation.P));
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder result = new StringBuilder();
        whitePawns.stream().forEach((x) -> result.append(x.getRepresentation().getValue()));
        return result.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder result = new StringBuilder();
        blackPawns.stream().forEach((x) -> result.append(x.getRepresentation().getValue()));
        return result.toString();
    }
}
