package net.jung.chess;

import net.jung.chess.pieces.Pawn;

import java.util.*;

public class Board {
    private List<Pawn> blackPawnList = new ArrayList();
    private List<Pawn> whitePawnList = new ArrayList();

    public void addWhitePawn(Pawn pawn) {
        if(pawn.getColor() == Color.WHITE)
        whitePawnList.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        if(pawn.getColor() == Color.BLACK)
        blackPawnList.add(pawn);
    }

    public int size() {
        return whitePawnList.size() + blackPawnList.size();
    }

    public int whitePawnListSize() {
        return whitePawnList.size();
    }

    public int blackPawnListSize() {
        return blackPawnList.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawnList.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawnList.get(index);
    }

    public void initialize() {
        int MAX_PAWNS_SIZE =8;
        for (int i = 0; i < MAX_PAWNS_SIZE; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
            addBlackPawn(new Pawn(Color.BLACK));
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
        String blankRow = "********";
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
