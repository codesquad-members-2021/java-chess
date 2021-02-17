package net.jung.chess;

import net.jung.chess.pieces.Pawn;

import java.util.*;

public class Board {
    private List<Pawn> blackPawnList = new ArrayList();
    private List<Pawn> whitePawnList = new ArrayList();
    private final int MAX_PAWNS_SIZE = 8;
    private String blankRow = "********";

    public void add(Pawn pawn) {
        if (pawn.getColor() == (Color.WHITE)) {
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
            add(new Pawn(Color.WHITE));
            add(new Pawn(Color.BLACK));
        }
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawnList);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawnList);
    }

    public String getPawnsResult(List<Pawn> pawnList) {
        StringBuilder pawnReps = new StringBuilder();
        int colorPawnSize = pawnList.size();
        for (int i = 0; i < colorPawnSize; i++) {
            pawnReps.append(pawnList.get(i).getRepresentation());
        }
        return pawnReps.toString();
    }

    public String print() {
        StringBuilder boardLayout = new StringBuilder();
        boardLayout.append(blankRow + "\n")
                .append(getBlackPawnsResult()+"\n")
                .append(blankRow + "\n")
                .append(blankRow + "\n")
                .append(blankRow + "\n")
                .append(blankRow + "\n")
                .append(getWhitePawnsResult()+"\n")
                .append(blankRow);
        return boardLayout.toString();
    }

    public void reset(){
        whitePawnList.clear();
        blackPawnList.clear();
    }


}
