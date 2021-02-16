package net.jung.chess;

import net.jung.chess.pieces.Pawn;

import java.util.*;

public class Board {
    private List<Pawn> blackPawnList = new ArrayList();
    private List<Pawn> whitePawnList = new ArrayList();
    private final int MAX_PAWNS_SIZE = 8;

    public void add(Pawn pawn) {
        if (pawn.getColor()== (Color.WHITE)) {
            whitePawnList.add(pawn);
            return;
        }
        blackPawnList.add(pawn);

    }

    public int size() {
        return whitePawnList.size() + blackPawnList.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawnList.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawnList.get(index);
    }

    public void initialize() {
        for (int i = 0; i < MAX_PAWNS_SIZE; i++) {
            Pawn whitePawn = new Pawn(Color.WHITE);
            Pawn blackPawn = new Pawn(Color.BLACK);
            add(whitePawn);
            add(blackPawn);
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder pawnReps = new StringBuilder();
        int whiteSize = whitePawnList.size();

        for (int i = 0; i < whiteSize; i++) {
            pawnReps.append(whitePawnList.get(i).getRepresentation());
        }
        return pawnReps.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder pawnReps = new StringBuilder();
        int blackSize = blackPawnList.size();

        for (int i = 0; i < blackSize; i++) {
            pawnReps.append(blackPawnList.get(i).getRepresentation());
        }
        return pawnReps.toString();
    }


}
