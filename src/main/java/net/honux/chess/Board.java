package net.honux.chess;

import net.honux.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {

    ArrayList<Pawn> pawns = new ArrayList<Pawn>();

    StringBuilder whiteResult = new StringBuilder();
    StringBuilder blackResult = new StringBuilder();

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
        ArrayList<Pawn> whitePawns = new ArrayList<Pawn>();
        ArrayList<Pawn> blackPawns = new ArrayList<Pawn>();

        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION));
        }

        for (int i = 0; i < whitePawns.size(); i++) {
            whiteResult.append(whitePawns.get(i).getRepresentation());
            blackResult.append(blackPawns.get(i).getRepresentation());
        }

    }

    public String getWhitePawnsResult() {
        return whiteResult.toString();

    }

    public String getBlackPawnsResult() {
        return blackResult.toString();
    }
}
