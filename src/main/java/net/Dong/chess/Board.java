package net.Dong.chess;

import static net.Dong.chess.Pawn.Color;

import java.util.List;
import java.util.ArrayList;

public class Board {
    private List<Pawn> whitePawn = new ArrayList<>();
    private List<Pawn> blackPawn = new ArrayList<>();


    public void addWhite(Pawn pawn) {
        whitePawn.add(pawn);
    }

    public void addBlack(Pawn pawn) {
        blackPawn.add(pawn);
    }


    public int size() {
        return whitePawn.size() + blackPawn.size();
    }

    private int whitePawnSize() {
        return whitePawn.size();
    }

    public int blackPawnSize() {
        return blackPawn.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawn.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return whitePawn.get(index);
    }

    public void initialize() {
        addPawnWhite(8);
        addPawnBlack(8);
    }

    private void addPawnWhite(int numOfPawn) {
        for (int i = 0; i < numOfPawn; i++) {
            whitePawn.add(new Pawn(Color.WHITE));
        }
    }

    private void addPawnBlack(int numOfPawn) {
        for (int i = 0; i < numOfPawn; i++) {
            whitePawn.add(new Pawn(Color.BLACK));
        }
    }



    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawn);
    }


    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawn);
    }

    private String getPawnsResult(List<Pawn> whatPawn) {
        StringBuilder sb = new StringBuilder();
        int len = whatPawn.size();
        for (Pawn pawn : whatPawn) {
            sb.append(pawn.getSymbol());
        }
        return sb.toString();
    }


}
