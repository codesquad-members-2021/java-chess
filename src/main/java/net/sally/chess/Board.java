package net.sally.chess;

import net.sally.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();

    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

    public void initialize() {

        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn());
        }

        for (int i = 0; i < 8; i++) {
            blackPawns.add(new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder whitePawnsResult = new StringBuilder();
        for (Pawn whitePawn : whitePawns) {
            whitePawnsResult.append(whitePawn.getRepresentation());
        }
        return whitePawnsResult.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder blackPawnsResult = new StringBuilder();
        for (Pawn blackPawn : blackPawns) {
            blackPawnsResult.append(blackPawn.getRepresentation());
        }
        return blackPawnsResult.toString();

    }

    public void addPawn(Pawn pawn) {
        pawns.add(pawn);
    }

    public int getPawnSize() {
        return pawns.size();
    }

    public Pawn findPawn(int i) {
        return pawns.get(i);
    }
}
